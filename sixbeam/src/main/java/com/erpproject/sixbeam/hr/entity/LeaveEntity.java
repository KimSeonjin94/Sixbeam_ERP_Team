package com.erpproject.sixbeam.hr.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="HR_LEAVE_TB")
public class LeaveEntity {
    @Column
    private String leaveDt;//신청날짜
    @Id
    @ManyToOne
    @JoinColumn(name ="eiId")
    private EmpInfoEntity empInfoEntity;//사원아이디
    @Column
    private boolean leaveApply;//휴직신청
    @Column
    private LocalDate leaveStartDt;//휴직시작
    @Column
    private LocalDate leaveFinishDt;//휴직종료
    @ManyToOne
    @JoinColumn(name ="reasonCd")
    private ReasonEntity reasonEntity;//사유코드
}
