package com.erpproject.sixbeam.ac.dto;

import com.erpproject.sixbeam.ac.entity.ReceivablesEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceivablesDto {
    private String accountCd;
    private int receivablesSales;
    private int receivablesCollect;
    private int receivablesRest;


    public ReceivablesEntity toEntity() {

        return new ReceivablesEntity(accountCd,  receivablesSales,  receivablesCollect,  receivablesRest);
    }
}
