package com.erpproject.sixbeam.hr.dto;

import java.time.LocalDate;

public class LeaveDto {
    private String leaveDt;//신청날짜
    private String eiId;//사원아이디
    private boolean leaveApply;//휴직신청
    private LocalDate leaveStartDt;//휴직시작
    private LocalDate leaveFinishDt;//휴직종료
    private int reasonCode;//사유코드
}
