package com.erpproject.sixbeam.ac.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name="AC_BS_TB")
public class BsEntity {
    @Id
    @Column(name="BS_DT")
    private LocalDate bsDt;
    @Column(name="BS_CASH")
    private int bsCash;
    @Column(name="BS_RECEIVABLES")
    private int bsReceivables;
    @Column(name="BS_INVENTORIES")
    private int bsInventories;
    @Column(name="BS_LAND")
    private int bsLand;
    @Column(name="BS_BUILDING")
    private int bsBuilding;
    @Column(name="BS_FAC")
    private int bsFac;
    @Column(name="BS_PAYABLES")
    private int bsPayables;
    @Column(name="BS_LONG_BOR")
    private int bsLongBor;
    @Column(name="BS_CAPITAL")
    private int bsCapital;
    @Column(name="BS_EARNINGS")
    private int bsEarnings;
}
