package com.erpproject.sixbeam.st.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class CheckRowDeletedEvent<T> extends ApplicationEvent {
    private T entity;

    public CheckRowDeletedEvent(Object source, T entity) {
        super(source);
        this.entity = entity;
    }
}

