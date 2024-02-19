package com.erpproject.sixbeam.ss.dto;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.st.entity.CheckEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class EstimateDto {
    private String estimateCd;

    private LocalDate estimateDt;

    private ItemEntity itemEntity;

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
        EstimateEntity entity = new EstimateEntity();

        // Entity에 값을 설정하는 부분
        entity.setEstimateCd(this.estimateCd);
        entity.setEstimateDt(this.estimateDt);
        entity.setItemEntity(this.itemEntity);
        entity.setEmpInfoEntity(this.empInfoEntity);
        entity.setAccountEntity(this.accountEntity);
        entity.setEstimateNm(this.estimateNm);
        entity.setEstimateAmt(this.estimateAmt);
        entity.setEstimateUp(this.estimateUp);
        entity.setEstimateSp(this.estimateSp);
        entity.setEstimateVat(this.estimateVat);
        entity.setEstimateTamt(this.estimateTamt);
        entity.setEstimateEtc(this.estimateEtc);

        return entity;
    }
}
