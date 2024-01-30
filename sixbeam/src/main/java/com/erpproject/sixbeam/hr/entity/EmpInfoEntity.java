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
    @Column(name = "EI_ID")
    private String eiId;
    @Column(name = "EI_PW")
    private String eiPw;
    @Column(name = "EI_NM")
    private String eiNm;
    @Column(name = "EI_SEX", columnDefinition = "TINYINT(1)")
    private boolean eiSex;
    @Column(name = "EI_BIRTH")
    private LocalDate eiBirth;
    @Column(name = "EI_ADDR")
    private String eiAddr;
    @Column(name = "EI_PHONE")
    private String eiPhone;
    @Column(name = "EI_EMAIL")
    private String eiEmail;
    @Column(name = "EI_JOIN_DT")
    private LocalDate eiJoinDt;
    @Column(name = "EI_QUIT_DT")
    private LocalDate eiQuitDt;
    @Column(name = "EI_POSITION_CD")
    private String eiPositionCd;
    @Column(name = "EI_DEPART_CD")
    private String eiDepartCd;
    @Column(name = "EI_BANK")
    private String eiBank;
    @Column(name = "EI_ACCOUNT_NO")
    private String eiAccountNo;
    @Column(name = "EI_QR")
    private String eiQr;
    @Column(name = "EI_TOTALNOY")
    private int eiTotalnoy;
    @Column(name = "EI_ETC")
    private String eiEtc;
}
