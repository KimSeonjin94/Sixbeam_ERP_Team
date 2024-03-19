package com.erpproject.sixbeam.ac.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="AC_BS_TB")
public class BsEntity {
    @Id
    @Column(name="BS_DT" ,nullable = false)
    private String bsDt;
    @Column(name="BS_CASH",nullable = false)
    private long bsCash;
    @Column(name="BS_RECEIVABLES",nullable = false)
    private long bsReceivables;
    @Column(name="BS_INVENTORIES",nullable = false)
    private long bsInventories;
    @Column(name="BS_LAND",nullable = false)
    private long bsLand;
    @Column(name="BS_BUILDING",nullable = false)
    private long bsBuilding;
    @Column(name="BS_FAC",nullable = false)
    private long bsFac;
    @Column(name="BS_PAYABLES",nullable = false)
    private long bsPayables;
    @Column(name="BS_LONG_BOR",nullable = false)
    private long bsLongBor;
    @Column(name="BS_CAPITAL",nullable = false)
    private long bsCapital;
    @Column(name="BS_EARNINGS",nullable = false)
    private long bsEarnings;

}
