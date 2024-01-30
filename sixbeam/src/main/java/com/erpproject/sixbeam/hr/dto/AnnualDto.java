package com.erpproject.sixbeam.hr.dto;

import java.time.LocalDate;

public class AnnualDto {
    private LocalDate annualDt;//신청날짜
    private String eiId;//사원아이디
    private int annualCnt;//연차개수
    private boolean annualApply;//연차신청
    private LocalDate annualStartDt;//연차시작
    private LocalDate annualFinishDt;//연차 끝
    private String reasonCd;//사유코드
}
