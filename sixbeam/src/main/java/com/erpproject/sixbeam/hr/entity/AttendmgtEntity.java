package com.erpproject.sixbeam.hr.entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="HR_ATTENDMGT_TB")

public class AttendmgtEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="HR_ATTENDMGT_TB_attendmgtCd_seq")
    @SequenceGenerator(name ="HR_ATTENDMGT_TB_attendmgtCd_seq", sequenceName ="HR_ATTENDMGT_TB_attendmgtCd_seq",
            initialValue = 100001, allocationSize =1)
    @Column(name ="attendmgtCd")
    private Long attendmgtCd;//급여식별자
    @ManyToOne
    @JoinColumn(name = "empinfoId")
    private EmpInfoEntity empInfoEntity;//사원Id
    @Column(name ="AttendmgtTardy")
    private int AttendmgtTardy;//지각
    @Column(name ="AttendmgtLearly")
    private int AttendmgtLearly;//조퇴
    @Column(name ="AttendmgtAbsent")
    private int AttendmgtAbsent;//결석
    @Column(name ="AttendmgtOverTime")
    private int AttendmgtOverTime;//연장근무
}
