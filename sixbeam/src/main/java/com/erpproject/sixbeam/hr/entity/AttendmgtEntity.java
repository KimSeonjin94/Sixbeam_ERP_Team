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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "empinfoId")
    private EmpInfoEntity empInfoEntity;//사원Id
    private String title;
    private LocalDate start;
    private LocalDate end;
    private String backgroundColor;
}
