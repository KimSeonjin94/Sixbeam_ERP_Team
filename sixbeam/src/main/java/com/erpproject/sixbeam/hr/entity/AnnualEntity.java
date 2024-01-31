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
    @Column
    private LocalDate annualDt;//신청날짜
    @ManyToOne
    @JoinColumn(name = "eiId")
    private EmployeeInfoEntity employeeInfoEntity;//사원Id
    @Column
    private int annualCnt;//연차개수
    @Column
    private boolean annualApply;//연차신청
    @Column
    private LocalDate annualStartDt;//연차시작
    @Column
    private LocalDate annualFinishDt;//연차 끝
    @ManyToOne
    @JoinColumn(name ="reasonCd")
    private ReasonEntity reasonEntity;//사유코드

}
