package com.erpproject.sixbeam.ss.dto;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.ss.entity.CheckEntity;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

public class EstimateDto {
    private String estimateCd;


    private LocalDate estimateDt;

    private String itemCd;

    private CheckEntity checkEntity;


    private EmpInfoEntity empInfoEntity;

    private AccountEntity accountEntity;

    private String estimateNm;

    private int estimateAmt;

    private int estimateUp;

    private int estimateSp;

    private int estimateVat;

    private int estimateTamt;

    private String estimateEtc;

    public EstimateEntity toEntity() {
        return new EstimateEntity(estimateCd,estimateDt,itemCd,checkEntity,empInfoEntity,accountEntity,estimateNm,estimateAmt,estimateUp,estimateSp,estimateVat,estimateTamt,estimateEtc);
    }
}
