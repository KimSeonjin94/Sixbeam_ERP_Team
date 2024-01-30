package com.erpproject.sixbeam.ac.dto;

import com.erpproject.sixbeam.ac.entity.SalesEntity;
import lombok.Getter;
import lombok.Setter;


public class SalesDto {
    private String salesNb;
    private String accountCd;;
    private String saleCd;
    private String salesEtc;
    private String salesSubject;
    private String salesBank;

    public SalesEntity toEntity() {

        return new SalesEntity(salesNb, accountCd, saleCd, salesEtc, salesSubject, salesBank);
    }
}
