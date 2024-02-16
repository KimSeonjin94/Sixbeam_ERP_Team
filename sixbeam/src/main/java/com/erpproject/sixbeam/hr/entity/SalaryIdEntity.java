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
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="HR_SALARYID_TB_salaryIdCd_seq")
    @SequenceGenerator(name ="HR_SALARYID_TB_salaryIdCd_seq", sequenceName ="HR_SALARYID_TB_salaryIdCd_seq",
            initialValue = 801, allocationSize =1)
    @Column(name ="salaryIdCd")
    private Long salaryIdCd;//급여식별자
    @ManyToOne
    @JoinColumn(name ="departCd")
    private DepartEntity departEntity;//부서코드
    @ManyToOne
    @JoinColumn(name ="positionCd")
    private PositionEntity positionEntity;//직책코드
    @Column(name ="basicSalary")
    private int basicSalary;//기본급여
}
