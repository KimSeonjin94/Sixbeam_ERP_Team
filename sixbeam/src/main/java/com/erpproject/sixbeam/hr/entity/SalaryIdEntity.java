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
    private int salaryCd;//급여식별자
    @ManyToOne
    @JoinColumn(name ="departCd")
    private DepartEntity departEntity;//부서코드
    @ManyToOne
    @JoinColumn(name ="positionCd")
    private PositionEntity positionEntity;//직책코드
    @Column
    private int basicSalary;//기본급여
}
