package com.erpproject.sixbeam.st;

import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.st.entity.AsEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class RowAddedEvent<T> extends ApplicationEvent{
    private T entity;

    public RowAddedEvent(Object source, T entity) {
        super(source);
        this.entity = entity;
    }
}
