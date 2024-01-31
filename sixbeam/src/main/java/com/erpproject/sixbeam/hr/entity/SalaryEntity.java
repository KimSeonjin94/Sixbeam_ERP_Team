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
    private int salarySmonth;//급여 월
    @ManyToOne
    @JoinColumn(name = "salaryCd")
    private SalaryIdEntity salaryIdEntity;//급여식별자
    @ManyToOne
    @JoinColumn(name ="eiId")
    private EmpInfoEntity empInfoEntity;//사원아이디
    @Column
    private int bouns;//상여금
    @Column
    private int allowance;//수당금
    @Column
    private int incentive;//성과금
    @Column
    private int totalMoney;//총지급액
}
