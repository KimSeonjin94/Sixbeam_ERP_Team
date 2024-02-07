package com.erpproject.sixbeam.hr.entity;

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
@Table(name="HR_SALARY_TB")
public class SalaryEntity {


    @Id
    @Column(name="empinfoId",insertable = false,updatable = false)
    private Long empInfoId;
    @ManyToOne
    @JoinColumn(name = "empinfoId")
    private EmpInfoEntity empInfoEntity;//사원Id
    @Column(name ="salarySmonth")
    private int salarySmonth;//급여 월
    @ManyToOne
    @JoinColumn(name = "salaryCd")
    private SalaryIdEntity salaryidEntity;//급여식별자
    @Column(name ="salaryBonus")
    private int salaryBonus;//상여금
    @Column(name ="salaryAllow")
    private int salaryAllow;//수당금
    @Column(name ="salaryIncentive")
    private int salaryIncentive;//성과금
    @Column(name ="salaryTtmoney")
    private int salaryTtmoney;//총지급액
}
