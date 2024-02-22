package com.erpproject.sixbeam.st;

import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.st.entity.AsEntity;
import org.springframework.context.ApplicationEvent;

public class RowAddedEvent extends ApplicationEvent {
    private SaleEntity saleEntity;
    private AsEntity asEntity;

    private  InputEntity inputEntity;
    public RowAddedEvent(Object source) {
        super(source);
    }
    //AS테이블 전용-----------------------------------------
    public RowAddedEvent(Object source, AsEntity asEntity) {
        super(source);
        this.asEntity = asEntity;
    }
    public AsEntity getAsEntity() {
        return asEntity;
    }
    //----------------------------------------------------

    //Sale테이블 전용-----------------------------------------
    public RowAddedEvent(Object source, SaleEntity saleEntity) {
        super(source);
        this.saleEntity = saleEntity;
    }
    public SaleEntity getSaleEntity() {
        return saleEntity;
    }
    //----------------------------------------------------

    //Input테이블 전용-----------------------------------------
    public RowAddedEvent(Object source, InputEntity inputEntity) {
        super(source);
        this.inputEntity = inputEntity;
    }
    public InputEntity getInputEntity() {
        return inputEntity;
    }
    //----------------------------------------------------
}
