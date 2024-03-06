package com.erpproject.sixbeam.st.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class CheckRowUpdatedEvent<T> extends ApplicationEvent {
    private T entity;

    public CheckRowUpdatedEvent(Object source, T entity){
        super(source);
        this.entity = entity;
    }
}
