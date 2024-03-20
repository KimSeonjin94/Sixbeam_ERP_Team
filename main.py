import pickle
from prophet import Prophet
import pandas as pd
import mysql.connector
from fastapi import FastAPI, HTTPException
from sqlalchemy import create_engine
from datetime import datetime

app = FastAPI()

engine = create_engine('mysql+mysqlconnector://root:1234@localhost/sixbeam_erp')

# 파일 경로 및 행 개수 추적 파일 설정
model_files = {'sales': 'sales_model.pkl', 'inputs': 'inputs_model.pkl'}
forecast_files = {'sales': 'sales_forecast.pkl', 'inputs': 'inputs_forecast.pkl'}
row_count_files = {'sales': 'sales_row_count.txt', 'inputs': 'inputs_row_count.txt'}
data_files = {'sales': 'sales_data_and_forecast.pkl', 'inputs': 'inputs_data_and_forecast.pkl'}


def fetch_data(query: str):

    df = pd.read_sql(query, engine)

    df['ds'] = pd.to_datetime(df['ds'])
    df_monthly = df.groupby(pd.Grouper(key='ds', freq='ME')).sum().reset_index()
    return df_monthly


def check_for_updates(table_name: str, current_row_count: int):
    # 테이블 행 개수가 변경되었는지 확인
    try:
        with open(row_count_files[table_name], 'r') as f:
            last_row_count = int(f.read())
    except FileNotFoundError:
        last_row_count = 0

    if last_row_count != current_row_count:
        return True  # 데이터가 변경되었음
    return False


def update_row_count(table_name: str, current_row_count: int):
    # 테이블 행 개수 업데이트
    with open(row_count_files[table_name], 'w') as f:
        f.write(str(current_row_count))


def train_and_save_data(df, forecast, table_name):
    # 데이터와 예측 결과를 함께 저장
    data_to_save = {
        'data': df,
        'forecast': forecast
    }
    with open(f'{table_name}_data_and_forecast.pkl', 'wb') as f:
        pickle.dump(data_to_save, f)


def train_and_save_model(df, table_name: str):
    model = Prophet(yearly_seasonality=True)
    model.fit(df)
    current_time = datetime.now()
    start_of_current_month = current_time.replace(day=1)
    future = model.make_future_dataframe(periods=12, freq='M')
    future = future[future['ds'] >= start_of_current_month].head(12)
    forecast = model.predict(future)

    # 모델과 예측 결과 저장
    with open(model_files[table_name], 'wb') as f_model, open(forecast_files[table_name], 'wb') as f_forecast:
        pickle.dump(model, f_model)
        pickle.dump(forecast, f_forecast)

    # 테이블 행 개수 업데이트
    update_row_count(table_name, len(df))
    train_and_save_data(df, forecast.groupby(pd.Grouper(key='ds', freq='ME'))['yhat'].sum().reset_index(), table_name)


@app.on_event("startup")
async def startup_event():
    # sales 데이터 처리
    sales_query = """
    SELECT s.sale_upload_dt AS ds, s.estimate_cd, e.estimate_amt AS y
    FROM ss_sale_tb s
    JOIN ss_estimate_tb e ON s.estimate_cd = e.estimate_cd
    """
    sales_df = fetch_data(sales_query)
    if check_for_updates('sales', len(sales_df)):
        train_and_save_model(sales_df, 'sales')

    # inputs 데이터 처리
    inputs_query = """
    SELECT s.inputpur_dt AS ds, s.orinput_cd, e.orinput_amt AS y
    FROM pur_input_tb s
    JOIN pur_orinput_tb e ON s.orinput_cd = e.orinput_cd
    """
    inputs_df = fetch_data(inputs_query)
    if check_for_updates('inputs', len(inputs_df)):
        train_and_save_model(inputs_df, 'inputs')


@app.get("/sales-summary")
async def get_sales_summary():
    try:
        with open('sales_data_and_forecast.pkl', 'rb') as f:
            loaded_data = pickle.load(f)
            sales_data = loaded_data['data']
            forecast = loaded_data['forecast']  # 예측 결과
    except FileNotFoundError:
        raise HTTPException(status_code=404, detail="Sales data and forecast not found.")

    # 과거 데이터와 예측 결과를 조합하여 JSON 형식으로 반환
    return {
        'grapeSales': sales_data.to_dict('records'),
        'preGrapes': forecast[['ds', 'yhat']].to_dict('records')
    }


@app.get("/input-summary")
async def get_input_summary():
    try:
        with open('inputs_data_and_forecast.pkl', 'rb') as f:
            loaded_data = pickle.load(f)
            inputs_data = loaded_data['data'] # 과거 구매 데이터
            forecast = loaded_data['forecast']  # 예측 결과
    except FileNotFoundError:
        raise HTTPException(status_code=404, detail="Sales data and forecast not found.")

    # 과거 데이터와 예측 결과를 조합하여 JSON 형식으로 반환
    return {
        'grapeSales': inputs_data.to_dict('records'),
        'preGrapes': forecast[['ds', 'yhat']].to_dict('records')
    }
# uvicorn main:app --reload 콘솔창에서 실행하여 확인