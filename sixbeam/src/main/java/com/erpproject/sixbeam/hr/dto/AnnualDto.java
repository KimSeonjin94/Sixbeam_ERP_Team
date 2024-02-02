package com.erpproject.sixbeam.hr.dto;

import com.erpproject.sixbeam.hr.entity.AnnualEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.ReasonEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnnualDto {
    private Long empInfoId;
    private EmpInfoEntity empInfoEntity;//사원아이디
    private LocalDate annualDt;//신청날짜
    private int annualCnt;//연차개수
    private boolean annualApply;//연차신청
    private LocalDate annualStartDt;//연차시작
    private LocalDate annualFinishDt;//연차 끝
    private ReasonEntity reasonEntity;//사유코드

    public AnnualEntity toEntity() {
        return new AnnualEntity(empInfoId, empInfoEntity, annualDt, annualCnt, annualApply,
                annualStartDt, annualFinishDt, reasonEntity);
    }
}
