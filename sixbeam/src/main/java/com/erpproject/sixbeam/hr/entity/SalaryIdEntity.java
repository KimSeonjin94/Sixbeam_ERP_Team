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
@Table(name="HR_SALARYID_TB")

public class SalaryIdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="HR_SALARYID_TB_salaryCd_seq")
    @SequenceGenerator(name ="HR_SALARYID_TB_salaryCd_seq", sequenceName ="HR_SALARYID_TB_salaryCd_seq",
            initialValue = 801, allocationSize =1)
    @Column(name ="salaryCd")
    private Long salaryCd;//급여식별자
    @ManyToOne
    @JoinColumn(name ="departCd")
    private DepartEntity departEntity;//부서코드
    @ManyToOne
    @JoinColumn(name ="positionCd")
    private PositionEntity positionEntity;//직책코드
    @Column(name ="basicSalary")
    private int basicSalary;//기본급여
}
