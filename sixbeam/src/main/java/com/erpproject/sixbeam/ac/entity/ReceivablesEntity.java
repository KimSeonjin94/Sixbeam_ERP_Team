package com.erpproject.sixbeam.ac.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="AC_RECEIVABLES_TB")
public class ReceivablesEntity {
    @Id
    @Column(name="ACCOUNT_CD")
    private String accountCd;
    @Column(name="RECEIVABLES_SALES")
    private int receivablesSales;
    @Column(name="RECEIVABLES_COLLECT")
    private int receivablesCollect;
    @Column(name="RECEIVABLES_REST")
    private int receivablesRest;

    public ReceivablesEntity(String accountCd, int receivablesSales, int receivablesCollect, int receivablesRest) {
        this.accountCd = accountCd;
        this.receivablesSales = receivablesSales;
        this.receivablesCollect = receivablesCollect;
        this.receivablesRest = receivablesRest;
    }
}
