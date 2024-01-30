package com.erpproject.sixbeam.ac.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="AC_PUR_TB")
public class PurEntity {
    @Id
    @Column(name="PUR_NB")
    private String purNb;
    @Column(name="ACCOUNT_CD")
    private String accountCd;
    @Column(name="PI_CD")
    private String piCd;
    @Column(name="PUR_ETC")
    private String purEtc;
    @Column(name="PUR_SUBJECT")
    private String purSubject;
    @Column(name="SALES_BANK")
    private String salesBank;

    public PurEntity(String purNb, String accountCd, String piCd, String purEtc, String purSubject, String salesBank) {
        this.purNb = purNb;
        this.accountCd = accountCd;
        this.piCd = piCd;
        this.purEtc = purEtc;
        this.purSubject = purSubject;
        this.salesBank = salesBank;
    }
}
