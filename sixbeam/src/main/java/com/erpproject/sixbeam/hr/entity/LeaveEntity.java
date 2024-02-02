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
    @Id
    @Column(name="empinfoId",insertable = false,updatable = false)
    private Long empInfoId;
    @ManyToOne
    @JoinColumn(name = "empinfoId")
    private EmpInfoEntity empInfoEntity;//사원Id
    @Column(name ="leaveDt")
    private String leaveDt;//신청날짜
    @Column(name ="leaveApply")
    private boolean leaveApply;//휴직신청
    @Column(name ="leaveStartDt")
    private LocalDate leaveStartDt;//휴직시작
    @Column(name ="leaveFinishDt")
    private LocalDate leaveFinishDt;//휴직종료
    @ManyToOne
    @JoinColumn(name ="reasonCd")
    private ReasonEntity reasonEntity;//사유코드
}
