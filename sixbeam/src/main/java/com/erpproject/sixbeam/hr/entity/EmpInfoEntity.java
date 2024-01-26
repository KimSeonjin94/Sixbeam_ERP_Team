package com.erpproject.sixbeam.hr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="HR_EMPINFO_TB")
public class EmpInfoEntity {
    @Id
    private String EI_ID;
    @Column
    private String EI_PW;
    @Column
    private String EI_NM;
    @Column(columnDefinition = "TINYINT(1)")
    private boolean EI_SEX;
    @Column
    private LocalDate EI_BIRTH;
    @Column
    private String EI_ADDR;
    @Column
    private String EI_PHONE;
    @Column
    private String EI_EMAIL;
    @Column
    private LocalDate EI_JOIN_DT;
    @Column
    private LocalDate EI_QUIT_DT;
    @Column
    private String EI_POSITION_CD;
    @Column
    private String EI_DEPART_CD;
    @Column
    private String EI_BANK;
    @Column
    private String EI_ACCOUNT_NO;
    @Column
    private String EI_QR;
    @Column
    private int EI_TOTALNOY;
    @Column
    private String EI_ETC;
}
