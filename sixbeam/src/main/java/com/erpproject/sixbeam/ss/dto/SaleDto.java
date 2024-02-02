package com.erpproject.sixbeam.ss.dto;

import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.st.entity.ReleaseEntity;


import java.time.LocalDate;


public class SaleDto {

    private String saleCd;

    private EstimateEntity estimateEntity;

    private LocalDate saleUploadDt;

    private  LocalDate saleBillingDt;

    private  boolean saleBillingSt;

    private  LocalDate salePaymentDt;

    private ReleaseEntity releaseEntity;

    private String saleShippingSt;
    private LocalDate saleShippingDt;
    public SaleEntity toEtity() {
        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setSaleCd(this.saleCd);
        saleEntity.setEstimateEntity(this.estimateEntity);
        saleEntity.setSaleUploadDt(this.saleUploadDt);
        saleEntity.setSaleBillingDt(this.saleBillingDt);
        saleEntity.setSaleBillingSt(this.saleBillingSt);
        saleEntity.setSalePaymentDt(this.salePaymentDt);
        saleEntity.setReleaseEntity(this.releaseEntity);
        saleEntity.setSaleShippingSt(this.saleShippingSt);
        saleEntity.setSaleShippingDt(this.saleShippingDt);

        return saleEntity;
    }
}
