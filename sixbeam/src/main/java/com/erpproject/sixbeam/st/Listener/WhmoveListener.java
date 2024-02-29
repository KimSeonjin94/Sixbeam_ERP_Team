package com.erpproject.sixbeam.st.Listener;

import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.event.WhmoveRowAddedEvent;
import com.erpproject.sixbeam.st.event.WhmoveRowDeletedEvent;
import com.erpproject.sixbeam.st.service.WhmoveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class WhmoveListener {
    private final WhmoveService whmoveService;

    @Autowired
    public WhmoveListener(WhmoveService whmoveService) {
        this.whmoveService = whmoveService;
    }

    @EventListener
    public void handleRowAddedEvent(WhmoveRowAddedEvent<?> event) {
        if (event.getEntity() instanceof SaleEntity) {
            SaleEntity saleEntity = (SaleEntity) event.getEntity();
            // SaleEntity에 대한 처리
            whmoveService.addRowSale(saleEntity);
        } else if (event.getEntity() instanceof InputEntity) {
            InputEntity inputEntity = (InputEntity) event.getEntity();
            // InputEntity에 대한 처리
            whmoveService.addRowInput(inputEntity);
        } else if (event.getEntity() instanceof AsEntity ){
            AsEntity asEntity = (AsEntity) event.getEntity();
            // AsEntity에 대한 처리
            whmoveService.addRowAs(asEntity);
        }
    }
    @EventListener
    public void handleRowDeletedEvent(WhmoveRowDeletedEvent<?> event) {
        if (event.getEntity() instanceof List<?>) {
            List<?> entities = (List<?>) event.getEntity();
            for (Object entity : entities) {
                if (entity instanceof SaleEntity) {
                    SaleEntity saleEntity = (SaleEntity) entity;
                    // SaleEntity에 대한 삭제 처리
                    whmoveService.deleteRowSale(saleEntity);
                } else if (entity instanceof InputEntity) {
                    InputEntity inputEntity = (InputEntity) entity;
                    // InputEntity에 대한 삭제 처리
                    whmoveService.deleteRowInput(inputEntity);
                } else if (entity instanceof AsEntity) {
                    AsEntity asEntity = (AsEntity) entity;
                    // AsEntity에 대한 삭제 처리
                    whmoveService.deleteRowAs(asEntity);
                }
            }
        }
    }

}
