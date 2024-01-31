package com.erpproject.sixbeam.hr.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AttendmgtDto {
    private LocalDate workDt;//일자
    private String eiId;//사원번호
    private int tardy;//지각
    private int learly;//조퇴
    private int absent;//결석
    private int wgOut;//외근
    private int sL;//병가
    private LocalTime workTm;//출근시간
    private LocalTime leaveworkTm;//퇴근시간
    private LocalTime restTm;//휴계시간
    private LocalTime overTm;//초과근무
    private LocalTime workingTm;//근무시간
    private String reasonCd;//사유코드
}
