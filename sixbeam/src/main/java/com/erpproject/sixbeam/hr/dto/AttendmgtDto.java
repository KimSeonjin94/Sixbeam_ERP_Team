package com.erpproject.sixbeam.hr.dto;

import com.erpproject.sixbeam.hr.entity.AttendmgtEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.ReasonEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
public class AttendmgtDto {
    private String empInfoId;
    private EmpInfoEntity empInfoEntity;//사원번호
    private LocalDate attendmtWorkDt;//일자
    private int attendmtTardy;//지각
    private int attendmtLearly;//조퇴
    private int attendmtAbsent;//결석
    private int attendmtWgOut;//외근
    private int attendmtSL;//병가
    private LocalTime attendmtWorkTm;//출근시간
    private LocalTime attendmtLeaveworkTm;//퇴근시간
    private LocalTime attendmtRestTm;//휴계시간
    private LocalTime attendmtOverTm;//초과근무
    private LocalTime attendmtWorkingTm;//근무시간
    private ReasonEntity reasonEntity;//사유코드
    public AttendmgtEntity toEntity(){
        return new AttendmgtEntity(empInfoId,empInfoEntity,attendmtWorkDt,attendmtTardy,attendmtLearly,attendmtAbsent,attendmtWgOut,
                attendmtSL,attendmtWorkTm,attendmtLeaveworkTm,attendmtRestTm,attendmtOverTm,attendmtWorkingTm,reasonEntity);
    };
}
