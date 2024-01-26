package com.erpproject.sixbeam.ss.dto;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import java.time.LocalDate;

public class EstimateDto {
    private String estimateCd;
    private LocalDate estimateDt;
    private int checkAmt;
    private EmpInfoEntity empInfoEntity;
    private AccountEntity accountEntity;
    private String estimateNm;
    private ItemEntity itemEntity;
    private int estimateAmt;
    private int estimateUp;
    private int estimateSp;
    private int estimateVat;
    private int estimateTamt;
    private String estimateEtc;

    public EstimateEntity toEntity() {
        return new EstimateEntity(estimateCd, estimateDt, checkAmt, empInfoEntity, accountEntity estimateNm, itemEntity, estimateAmt, estimateUp, estimateSp, estimateVat, estimateTamt, estimateEtc);
    }
}
