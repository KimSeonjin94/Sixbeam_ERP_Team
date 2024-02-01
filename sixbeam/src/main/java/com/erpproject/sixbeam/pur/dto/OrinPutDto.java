package com.erpproject.sixbeam.pur.dto;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;

import java.time.LocalDate;

public class OrinPutDto {
    private String poCd;
    private LocalDate purReqDt;
    private LocalDate orderDt;
    private EmpInfoEntity empInfoEntity;
    private ItemEntity itemEntity;
    private int orinputAmt;
    private int orinputUp;
    private int orinputSp;
    private int orinputVat;
    private int orinputSum;
    private AccountEntity accountEntity;
    private LocalDate deliveryDt;
    private String orinputEtc;
}
