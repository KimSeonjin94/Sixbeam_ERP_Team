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
    @Column(name="empinfoId",insertable = false,updatable = false)
    private String empInfoId;
    @ManyToOne
    @JoinColumn(name = "empinfoId")
    private EmpInfoEntity empInfoEntity;//사원Id
    @Column(name ="AttendmgtWorkDt")
    private LocalDate AttendmgtWorkDt;//일자
    @Column(name ="AttendmgtTardy")
    private int AttendmgtTardy;//지각
    @Column(name ="AttendmgtLearly")
    private int AttendmgtLearly;//조퇴
    @Column(name ="AttendmgtAbsent")
    private int AttendmgtAbsent;//결석
    @Column(name ="AttendmgtWgout")
    private int AttendmgtWgOut;//외근
    @Column(name ="AttendmgtSl")
    private int AttendmgtSL;//병가
    @Column(name ="AttendmgtWorkTm")
    private LocalTime AttendmgtWorkTm;//출근시간
    @Column(name ="AttendmgtLeaveworkTm")
    private LocalTime AttendmgtLeaveworkTm;//퇴근시간
    @Column(name ="AttendmgtRestTm")
    private LocalTime AttendmgtRestTm;//휴계시간
    @Column(name ="AttendmgtOverTm")
    private LocalTime AttendmgtOverTm;//초과근무
    @Column(name ="AttendmgtWorkingTm")
    private LocalTime AttendmgtWorkingTm;//근무시간
    @ManyToOne
    @JoinColumn(name ="reasonCd")
    private ReasonEntity reasonEntity;//사유코드
}
