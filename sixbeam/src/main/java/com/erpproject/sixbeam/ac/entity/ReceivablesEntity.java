package com.erpproject.sixbeam.ac.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="AC_RECEIVABLES_TB")
public class ReceivablesEntity {
    @Id
    @Column(name="ACCOUNT_CD" ,insertable=false, updatable=false,nullable = false)
    private String accountCd;

    @ManyToOne
    @JoinColumn(name="ACCOUNT_CD")
    private AccountEntity accountEntity;
    @Column(name="RECEIVABLES_SALES",nullable = false)
    private int receivablesSales;
    @Column(name="RECEIVABLES_COLLECT",nullable = false)
    private int receivablesCollect;
    @Column(name="RECEIVABLES_REST",nullable = false)
    private int receivablesRest;

}
