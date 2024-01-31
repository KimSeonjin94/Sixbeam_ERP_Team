package com.erpproject.sixbeam.ac.dto;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.entity.PurEntity;


public class PurDto {
    private String purNb;
    private AccountEntity accountEntity;
    private InputEntity inputEntity;
    private String purEtc;
    private String purSubject;



    public PurEntity toEntity() {

        return new PurEntity(purNb, accountEntity, inputEntity, purEtc, purSubject);
    }
}
