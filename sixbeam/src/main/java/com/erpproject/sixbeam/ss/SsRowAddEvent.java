package com.erpproject.sixbeam.ss;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class SsRowAddEvent<T> extends ApplicationEvent {
    private T entity;

    public SsRowAddEvent(Object source, T entity) {
        super(source);
        this.entity = entity;

    }
}
