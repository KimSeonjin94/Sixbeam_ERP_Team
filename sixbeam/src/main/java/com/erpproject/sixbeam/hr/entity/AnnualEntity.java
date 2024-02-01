package com.erpproject.sixbeam.hr.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="HR_ANNNAL_TB")
public class AnnualEntity {
    @Id
    @Column(name="empInfoId",insertable = false,updatable = false)
    private String empInfoId;
    @ManyToOne
    @JoinColumn(name = "empInfoId")
    private EmpInfoEntity empInfoEntity;//사원Id
    @Column(name = "annualDt")
    private LocalDate annualDt;//신청날짜
    @Column(name ="annualCnt")
    private int annualCnt;//연차개수
    @Column(name ="annualApply")
    private boolean annualApply;//연차신청
    @Column(name ="annualStartDt")
    private LocalDate annualStartDt;//연차시작
    @Column(name ="annualFinishDt")
    private LocalDate annualFinishDt;//연차 끝
    @ManyToOne
    @JoinColumn(name ="reasonCd")
    private ReasonEntity reasonEntity;//사유코드

}
