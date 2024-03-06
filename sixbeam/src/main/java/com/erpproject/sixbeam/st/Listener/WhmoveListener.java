package com.erpproject.sixbeam.st.Listener;

import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.event.WhmoveRowAddedEvent;
import com.erpproject.sixbeam.st.event.WhmoveRowDeletedEvent;
import com.erpproject.sixbeam.st.event.WhmoveRowUpdatedEvent;
import com.erpproject.sixbeam.st.service.WhmoveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    public void handleRowAddedEvent(WhmoveRowAddedEvent<?> event) { //판매,구매,AS의 전표등록 시 창고이동으로 행이 추가되는 이벤트리스너
        if (event.getEntity() instanceof SaleEntity) {
            // SaleEntity에 대한 처리
            SaleEntity saleEntity = (SaleEntity) event.getEntity();
            whmoveService.addRowSale(saleEntity);
        } else if (event.getEntity() instanceof InputEntity) {
            InputEntity inputEntity = (InputEntity) event.getEntity();
            // InputEntity에 대한 처리
            whmoveService.addRowInput(inputEntity);
        } else if (event.getEntity() instanceof AsEntity) {
            AsEntity asEntity = (AsEntity) event.getEntity();
            // AsEntity에 대한 처리
            whmoveService.addRowAs(asEntity);
        }
    }
    @EventListener
    public void handleRowUpdatedEvent(WhmoveRowUpdatedEvent<?> event) { //판매,구매,AS의 전표수정 시 창고이동 테이블의 해당 행이 수정되는 이벤트리스너
        if (event.getEntity() instanceof SaleEntity) {
            // SaleEntity에 대한 처리
            SaleEntity saleEntity = (SaleEntity) event.getEntity();
            whmoveService.updateRowSale(saleEntity);
        } else if (event.getEntity() instanceof  InputEntity) {
            // InputEntity에 대한 처리
            InputEntity inputEntity = (InputEntity) event.getEntity();
            whmoveService.updateRowInput(inputEntity);
        } else if (event.getEntity() instanceof  AsEntity) {
            AsEntity asEntity = (AsEntity) event.getEntity();
            whmoveService.updateRowAs(asEntity);
        }
    }
    @EventListener
    public void handleRowDeletedEvent(WhmoveRowDeletedEvent<?> event) { //판매,구매,AS의 전표삭제 시 창고이동 테이블의 해당 행 또는 행들이 삭제되는 이벤트리스너
        if (event.getEntities() instanceof SaleEntity) {
            List<SaleEntity> saleEntities = (List<SaleEntity>) event.getEntities();
            List<SaleEntity> tempSale = new ArrayList<>();
            for (SaleEntity saleEntity : saleEntities) {
                tempSale.add(saleEntity);
            }
            whmoveService.deleteRowSale(tempSale);
        } else if (event.getEntities() instanceof InputEntity) {
            List<InputEntity> inputEntities = (List<InputEntity>) event.getEntities();
            List<InputEntity> tempInput = new ArrayList<>();
            for (InputEntity inputEntity : inputEntities) {
                tempInput.add(inputEntity);
            }
            whmoveService.deleteRowInput(tempInput);
        } else if (event.getEntities() instanceof AsEntity) {
            List<AsEntity> asEntities = (List<AsEntity>) event.getEntities();
            List<AsEntity> tempAs = new ArrayList<>();
            for (AsEntity asEntity : asEntities) {
                tempAs.add(asEntity);
            }
            whmoveService.deleteRowAs(tempAs);
        }
    }
}
