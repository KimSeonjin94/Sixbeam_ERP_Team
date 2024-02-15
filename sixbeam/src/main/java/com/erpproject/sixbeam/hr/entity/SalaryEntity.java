package com.erpproject.sixbeam.hr.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.YearMonth;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="HR_SALARY_TB")
public class SalaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="HR_SALARY_TB_empSequence_seq")
    @SequenceGenerator(name ="HR_SALARY_TB_empSequence_seq", sequenceName ="HR_SALARY_TB_empSequence_seq",
            initialValue = 2001, allocationSize =1)
    @Column(name ="salaryCd")
    private Long salaryCd;//사원아이디
    @ManyToOne
    @JoinColumn(name = "empinfoId")
    private EmpInfoEntity empInfoEntity;//사원Id

    @Column(name ="salarySmonth")
    private YearMonth salarySmonth;//급여 월

    @ManyToOne
    @JoinColumn(name = "salaryIdCd")
    private SalaryIdEntity salaryIdEntity;//급여식별자

    @Column(name ="salaryBonus")
    private int salaryBonus;//상여금

    @Column(name ="salaryAllow")
    private int salaryAllow;//수당금

    @Column(name ="salaryIncentive")
    private int salaryIncentive;//성과금

    @Column(name ="salaryTtmoney")
    private int salaryTtmoney;//총지급액
}
