package com.erpproject.sixbeam.hr.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="HR_WORKSCHEDULE_TB")
public class WorkScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "HR_WORKSCHEDULE_TB_workScheduleCd_seq")
    @SequenceGenerator(name = "HR_WORKSCHEDULE_TB_workScheduleCd_seq", sequenceName = "HR_WORKSCHEDULE_TB_workScheduleCd_seq",
            initialValue = 10031, allocationSize = 1)
    @Column(name = "workScheduleCd")
    private Long workScheduleCd;//출퇴근 식별자
    @ManyToOne
    @JoinColumn(name = "empinfoId")
    private EmpInfoEntity empInfoEntity;//사원Id
    @Column(name="workScheduleCheck",columnDefinition = "TINYINT(1)")
    private boolean workScheduleCheck;//출퇴근 기록이 이상한 사람 체크
    @Column(name="workScheduleDate")
    private LocalDate workScheduleDate;//날짜
    @Column(name="workScheduleStartTime")
    private LocalTime workScheduleStartTime;//출근 시간
    @Column(name="workScheduleEndTime")
    private LocalTime workScheduleEndTime;//퇴근 시간
    @Column(name="workScheduleReason")
    private String workScheduleReason;//사유
}
