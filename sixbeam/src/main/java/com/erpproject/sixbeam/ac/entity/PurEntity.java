package com.erpproject.sixbeam.ac.entity;


import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
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
@Table(name="AC_PUR_TB")
public class PurEntity {

    @Column(name="PUR_NB",nullable = false)
    private String purNb;
    @ManyToOne
    @JoinColumn(name="ACCOUNT_CD")
    private AccountEntity accountEntity;
    @Id
    @Column(name="INPUTPUR_CD")
    private String inputPurCd;
    @Column(name="PUR_PRICE")
    private long purPrice;
    @Column(name="PUR_SUBJECT",nullable = false)
    private String purSubject;

    @ManyToOne
    @JoinColumn(name = "INPUTPUR_CD", referencedColumnName = "INPUTPUR_CD", insertable = false, updatable = false)
    private InputEntity inputEntity;

}
