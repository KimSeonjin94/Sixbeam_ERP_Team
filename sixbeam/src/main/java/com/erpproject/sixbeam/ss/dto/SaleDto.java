package com.erpproject.sixbeam.ss.dto;

import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.MemberEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class SaleDto {
    private String saleCd;
    private EstimateEntity estimateEntity;
    private LocalDate saleUploadDt;
    private  LocalDate saleBillingDt;
    private  boolean saleBillingSt;
    private  LocalDate salePaymentDt;
    private MoveEntity moveEntity;
    private String saleShippingSt;
    private LocalDate saleShippingDt;
    public SaleEntity toEntity(){
        return new SaleEntity(saleCd,estimateEntity,saleUploadDt,saleBillingDt,saleBillingSt,salePaymentDt,moveEntity,saleShippingSt,saleShippingDt);
    }
}
