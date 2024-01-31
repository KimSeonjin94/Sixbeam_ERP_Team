package com.erpproject.sixbeam.ac.dto;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.entity.ReceivablesEntity;


public class ReceivablesDto {
    private AccountEntity accountEntity;
    private int receivablesSales;
    private int receivablesCollect;
    private int receivablesRest;


    public ReceivablesEntity toEntity() {

        return new ReceivablesEntity(accountEntity,  receivablesSales,  receivablesCollect,  receivablesRest);
    }
}
