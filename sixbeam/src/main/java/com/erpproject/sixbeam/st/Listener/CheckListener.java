package com.erpproject.sixbeam.st.Listener;

import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.event.CheckRowAddedEvent;
import com.erpproject.sixbeam.st.event.CheckRowDeletedEvent;
import com.erpproject.sixbeam.st.event.CheckRowUpdatedEvent;
import com.erpproject.sixbeam.st.service.CheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CheckListener {

    private final CheckService checkService;

    @Autowired
    public CheckListener(CheckService checkService) {
        this.checkService = checkService;
    }

    @EventListener
    public void handleRowAddedEvent(CheckRowAddedEvent<WhmoveEntity> event) {
        WhmoveEntity whmoveEntity = event.getEntity();
        checkService.addRowCheck(whmoveEntity);
    }

    @EventListener
    public void handleRowUpdatedEvent(CheckRowUpdatedEvent<WhmoveEntity> event) {
        WhmoveEntity whmoveEntity = event.getEntity();
        checkService.updateRowCheck(whmoveEntity);
    }

    @EventListener
    public void handleRowDeletedEvent(CheckRowDeletedEvent<WhmoveEntity> event) {
        List<WhmoveEntity> entities = event.getEntities();
        List<String> temp = new ArrayList<>();
        for (WhmoveEntity entity : entities) {
            temp.add(entity.getWhmoveCd());
        }
        checkService.deleteRowCheck(temp);
    }

}
