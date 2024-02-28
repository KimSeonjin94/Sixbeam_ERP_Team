package com.erpproject.sixbeam.st;

import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.service.WhmoveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

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
}
