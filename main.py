from fastapi import FastAPI
from prophet import Prophet
import mysql.connector
import pandas as pd
from datetime import datetime, timedelta

app = FastAPI()

db_config = {
    'host': 'localhost',
    'port': 3306,  # 포트는 정수로 지정
    'user': 'root',
    'password': 'qwer1234',
    'database': 'sixbeam_erp',
    'raise_on_warnings': True,
    'use_pure': True,
    'charset': 'utf8mb4',
    'collation': 'utf8mb4_general_ci',
    'time_zone': "+00:00"
}


def sale_data():
    # 데이터베이스 연결
    conn = mysql.connector.connect(**db_config)

    # 판매 및 구매 데이터 로드
    # SQL 쿼리 실행
    query = """
    SELECT s.sale_upload_dt AS ds, s.estimate_cd, e.estimate_amt AS y
    FROM ss_sale_tb s
    JOIN ss_estimate_tb e ON s.estimate_cd = e.estimate_cd
    WHERE s.sale_upload_dt < CURDATE()
    """
    df = pd.read_sql(query, conn)



    # 판매 수량 계산 (여기서는 estimate_amt가 판매 수량으로 간주됨)
    # 필요한 경우 추가적인 계산을 수행합니다. 예를 들어, 날짜별 또는 estimate_cd별로 그룹화하여 합계를 구할 수 있습니다.
    sales_summary = df.groupby('ds')['y'].sum().reset_index()

    # 데이터베이스 연결 종료
    conn.close()

    # 데이터 확인
    print(df.head())

    # Prophet 모델 학습
    model = Prophet(daily_seasonality=True)
    model.fit(sales_summary)
    # 오늘 날짜 구하기
    today = datetime.today().date()

    # 오늘부터 7일 후까지의 날짜 리스트 생성
    future_dates = [today + timedelta(days=i) for i in range(8)]  # 오늘 포함 7일이므로 range(8)
    future_df = pd.DataFrame({'ds': future_dates})
    # 다음 일주일간 예측
    forecast = model.predict(future_df)
    # 현재 판매 데이터와 예측 결과를 JSON 형식으로 변환하여 반환
    sales_data = sales_summary.to_dict('records')
    predictions = forecast[['ds', 'yhat']].tail(7).to_dict('records')


    return {
        "grapeSales": sales_data,
        "preGrapes": predictions
    }


def inout_data():
    conn = mysql.connector.connect(**db_config)

    # 판매 및 구매 데이터 로드
    # SQL 쿼리 실행

    query = """
    SELECT s.inputpur_dt AS ds, s.orinput_cd, e.orinput_amt AS y
    FROM pur_input_tb s
    JOIN pur_orinput_tb e ON s.orinput_cd = e.orinput_cd
    WHERE s.inputpur_dt < CURDATE()
    """
    df = pd.read_sql(query, conn)

    # 판매 수량 계산 (여기서는 estimate_amt가 판매 수량으로 간주됨)
    # 필요한 경우 추가적인 계산을 수행합니다. 예를 들어, 날짜별 또는 estimate_cd별로 그룹화하여 합계를 구할 수 있습니다.
    inout_summary = df.groupby('ds')['y'].sum().reset_index()

    # 데이터베이스 연결 종료
    conn.close()

    # 데이터 확인
    print(df.head())

    model = Prophet(daily_seasonality=True)
    model.fit(inout_summary)
    # 오늘 날짜 구하기
    today = datetime.today().date()

    # 오늘부터 7일 후까지의 날짜 리스트 생성
    future_dates = [today + timedelta(days=i) for i in range(8)]  # 오늘 포함 7일이므로 range(8)
    future_df = pd.DataFrame({'ds': future_dates})
    # 다음 일주일간 예측
    forecast = model.predict(future_df)
    # 현재 판매 데이터와 예측 결과를 JSON 형식으로 변환하여 반환
    sales_data = inout_summary.to_dict('records')
    predictions = forecast[['ds', 'yhat']].tail(7).to_dict('records')

    return {
        "grapeSales": sales_data,
        "preGrapes": predictions
    }


@app.get("/sales-summary")
async def get_sales_summary():
    sales_summary = sale_data()
    # Pandas DataFrame을 JSON 형식으로 변환하여 반환
    return sales_summary


@app.get("/input-summary")
async def get_input_summary():
    input_summary = inout_data()
    # Pandas DataFrame을 JSON 형식으로 변환하여 반환
    return input_summary
# uvicorn main:app --reload 콘솔창에서 실행하여 확인
