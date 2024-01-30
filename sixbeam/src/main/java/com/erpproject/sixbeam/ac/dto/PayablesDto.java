package com.erpproject.sixbeam.ac.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayablesDto {
    private String accountCd;
    private int payablesPur;
    private int payablesPaid;
    private int payablesRest;
}
