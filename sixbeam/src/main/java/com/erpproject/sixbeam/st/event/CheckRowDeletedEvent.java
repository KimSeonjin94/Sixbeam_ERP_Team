package com.erpproject.sixbeam.st.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CheckRowDeletedEvent<T> extends ApplicationEvent {
    private List<T> entities;

    public CheckRowDeletedEvent(Object source, List<T> entities) {
        super(source);
        this.entities = new ArrayList<>(entities);
    }
}

