package com.erpproject.sixbeam.ss.dto;

import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;


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
    public SaleEntity toEntity(){
        return new SaleEntity(saleCd,estimateEntity,saleUploadDt,saleBillingDt,saleBillingSt,salePaymentDt,releaseEntity,saleShippingSt,saleShippingDt);
    }
}
