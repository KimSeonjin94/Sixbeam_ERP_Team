package com.erpproject.sixbeam.ac.dto;

import com.erpproject.sixbeam.ac.entity.PayablesEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayablesDto {
    private String accountCd;
    private int payablesPur;
    private int payablesPaid;
    private int payablesRest;

    public PayablesEntity toEntity() {

        return new PayablesEntity(accountCd, payablesPur, payablesPaid, payablesRest);
    }

}
