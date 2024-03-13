package com.erpproject.sixbeam.ac.dto;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.entity.PayablesEntity;

public class PayablesDto {
    private String accountCd;
    private String accountNm;
    private AccountEntity accountEntity;
    private int payablesPur;
    private int payablesPaid;
    private int payablesRest;

    public PayablesEntity toEntity() {

        return new PayablesEntity(accountCd,accountNm , accountEntity, payablesPur, payablesPaid, payablesRest);
    }
}
