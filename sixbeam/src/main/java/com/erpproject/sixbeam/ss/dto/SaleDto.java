package com.erpproject.sixbeam.ss.dto;

import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;


@Getter
@Setter
public class SaleDto {

    private String saleCd;

    private String estimateCd;

    private LocalDate saleUploadDt;

    private  LocalDate saleBillingDt;

    private  boolean saleBillingSt;

    private  LocalDate salePaymentDt;

    private WhregistEntity whregistEntity;

    private String saleShippingSt;
    private LocalDate saleShippingDt;
    public SaleEntity toEtity() {
        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setSaleCd(this.saleCd);
        saleEntity.setEstimateCd(this.estimateCd);
        saleEntity.setSaleUploadDt(this.saleUploadDt);
        saleEntity.setSaleBillingDt(this.saleBillingDt);
        saleEntity.setSaleBillingSt(this.saleBillingSt);
        saleEntity.setSalePaymentDt(this.salePaymentDt);
        saleEntity.setWhregistEntity(this.whregistEntity);
        saleEntity.setSaleShippingSt(this.saleShippingSt);
        saleEntity.setSaleShippingDt(this.saleShippingDt);

        return saleEntity;
    }
}
