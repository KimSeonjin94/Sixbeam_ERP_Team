package com.erpproject.sixbeam.ac.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceivablesDto {
    private String accountCd;
    private int receivablesSales;
    private int receivablesCollect;
    private int receivablesRest;
}
