package com.erpproject.sixbeam.ac.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="AC_PAYABLES_TB")
public class PayablesEntity {
    @Id
    @Column(name="ACCOUNT_CD" ,insertable=false, updatable=false ,nullable = false)
    private String accountCd;
    @Column(name="ACCOUNT_NM" ,insertable=false, updatable=false,nullable = false)
    private String accountNm;
    @ManyToOne
    @JoinColumn(name="ACCOUNT_CD")
    private AccountEntity accountEntity;
    @Column(name="PAYABLES_PUR" ,nullable = false)
    private long payablesPur;
    @Column(name="PAYABLES_PAID" ,nullable = false)
    private long payablesPaid;
    @Column(name="PAYABLES_REST" ,nullable = false)
    private long payablesRest;

}
