package com.erpproject.sixbeam.st;

import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.service.CheckService;
import com.erpproject.sixbeam.st.service.WhmoveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CheckListener {

    private final CheckService checkService;

    @Autowired
    public CheckListener(CheckService checkService) {
        this.checkService = checkService;
    }

    @EventListener
    public void handleRowAddedEvent(CheckRowAddedEvent<?> event) {
        if (event.getSource() instanceof WhmoveService) {
            WhmoveService whmoveService = (WhmoveService) event.getSource();
            if (event.getEntity() instanceof WhmoveEntity) {
                WhmoveEntity whmoveEntity = (WhmoveEntity) event.getEntity();
                checkService.addRowCheck(whmoveEntity);
            }
        }
    }
}
