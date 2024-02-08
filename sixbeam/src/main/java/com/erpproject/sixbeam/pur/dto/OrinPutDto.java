package com.erpproject.sixbeam.pur.dto;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class OrinPutDto {
    private String orinputCd;
    private LocalDate orinputReqDt;
    private LocalDate orinputOrDt;
    private EmpInfoEntity empInfoEntity;
    private ItemEntity itemEntity;
    private int orinputAmt;
    private int orinputUp;
    private int orinputSp;
    private int orinputVat;
    private int orinputSum;
    private AccountEntity accountEntity;
    private LocalDate orinputDlvyDt;
    private String orinputEtc;
}
