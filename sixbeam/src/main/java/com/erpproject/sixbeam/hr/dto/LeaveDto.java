package com.erpproject.sixbeam.hr.dto;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.LeaveEntity;
import com.erpproject.sixbeam.hr.entity.ReasonEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class LeaveDto {
    private Long empInfoId;
    private EmpInfoEntity empInfoEntity;//사원아이디
    private String leaveDt;//신청날짜
    private boolean leaveApply;//휴직신청
    private LocalDate leaveStartDt;//휴직시작
    private LocalDate leaveFinishDt;//휴직종료
    private ReasonEntity reasonEntity;//사유코드
    public LeaveEntity toEntity(){
        return new LeaveEntity(empInfoId,empInfoEntity,leaveDt,leaveApply,leaveStartDt,leaveFinishDt,reasonEntity);
    }
}
