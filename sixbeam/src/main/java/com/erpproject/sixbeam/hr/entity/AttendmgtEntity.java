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
    @Column
    private LocalDate workDt;//일자
    @Id
    @ManyToOne
    @JoinColumn(name ="eiId")
    private EmpInfoEntity empInfoEntity;//사원아이디
    @Column
    private int tardy;//지각
    @Column
    private int learly;//조퇴
    @Column
    private int absent;//결석
    @Column
    private int wgOut;//외근
    @Column
    private int sL;//병가
    @Column
    private LocalTime workTm;//출근시간
    @Column
    private LocalTime leaveworkTm;//퇴근시간
    @Column
    private LocalTime restTm;//휴계시간
    @Column
    private LocalTime overTm;//초과근무
    @Column
    private LocalTime workingTm;//근무시간
    @ManyToOne
    @JoinColumn(name ="reasonCd")
    private ReasonEntity reasonEntity;//사유코드
}
