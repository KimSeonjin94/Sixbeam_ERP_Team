package com.erpproject.sixbeam.st.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class WhmoveRowAddedEvent<T> extends ApplicationEvent{
    private T entity;

    public WhmoveRowAddedEvent(Object source, T entity) {
        super(source);
        this.entity = entity;
    }
}
