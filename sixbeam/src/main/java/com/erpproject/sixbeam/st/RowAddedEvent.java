package com.erpproject.sixbeam.st;

import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.st.entity.AsEntity;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
@Getter
public class RowAddedEvent<T>{
    private Object source;
    private T entity;
    public RowAddedEvent(Object source, T entity) {
        this.source =source;
        this.entity = entity;
    }


}
