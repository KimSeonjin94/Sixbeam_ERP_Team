package com.erpproject.sixbeam.ss;

import com.erpproject.sixbeam.ac.entity.SalesEntity;
import com.erpproject.sixbeam.ss.service.SaleService;
import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class SsListener {
    private SaleService saleService;

    @EventListener
    public void handleRowAddEvent(SsRowAddEvent<?> event){
        if(event.getEntity() instanceof ReleaseEntity){
            ReleaseEntity releaseEntity= (ReleaseEntity) event.getEntity();

            saleService.addRowRelease(releaseEntity);
        }else if(event.getEntity() instanceof SalesEntity){
            SalesEntity salesEntity = (SalesEntity) event.getEntity();

            saleService.addRowSales(salesEntity);

        }
    }


}
