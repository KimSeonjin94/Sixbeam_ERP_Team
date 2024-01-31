package com.erpproject.sixbeam.ac.dto;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.entity.SalesEntity;



public class SalesDto {
    private String salesNb;
    private AccountEntity accountEntity;
    private SaleEntity saleEntity;
    private String salesEtc;
    private String salesSubject;


    public SalesEntity toEntity() {

        return new SalesEntity(salesNb, accountEntity, saleEntity, salesEtc, salesSubject);
    }
}
