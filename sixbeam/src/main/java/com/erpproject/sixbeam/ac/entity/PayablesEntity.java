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
@Table(name="AC_PAYABLES_TB")
public class PayablesEntity {
    @Id
    @Column(name="ACCOUNT_CD" ,insertable=false, updatable=false)
    private String accountCd;

    @ManyToOne
    @JoinColumn(name="ACCOUNT_CD")
    private AccountEntity accountEntity;
    @Column(name="PAYABLES_PUR")
    private int payablesPur;
    @Column(name="PAYABLES_PAID")
    private int payablesPaid;
    @Column(name="PAYABLES_REST")
    private int payablesRest;

}
