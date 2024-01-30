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
@Table(name="AC_PAYABLES_TB")
public class PayablesEntity {
    @Id
    @Column(name="ACCOUNT_CD")
    private String accountCd;
    @Column(name="PAYABLES_PUR")
    private int payablesPur;
    @Column(name="PAYABLES_PAID")
    private int payablesPaid;
    @Column(name="PAYABLES_REST")
    private int payablesRest;

//    public PayablesEntity(String accountCd, int payablesPur, int payablesPaid, int payablesRest) {
//        this.accountCd = accountCd;
//        this.payablesPur = payablesPur;
//        this.payablesPaid = payablesPaid;
//        this.payablesRest = payablesRest;
//    }
}
