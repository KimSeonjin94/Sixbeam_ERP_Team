package com.erpproject.sixbeam.ac.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="AC_SALES_TB")
public class SalesEntity {
    @Id
    @Column(name="SALES_NB")
    private String salesNb;
    @Column(name="ACCOUNT_CD")
    private String accountCd;
    @Column(name="SALE_CD")
    private String saleCd;
    @Column(name="SALES_ETC")
    private String salesEtc;
    @Column(name="SALES_SUBJECT")
    private String salesSubject;
    @Column(name="SALES_BANK")
    private String salesBank;
}
