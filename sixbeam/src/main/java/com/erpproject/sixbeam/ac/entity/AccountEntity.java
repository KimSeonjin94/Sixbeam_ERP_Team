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
@Table(name="AC_ACCOUNT_TB")
public class AccountEntity {
    @Id
    @Column(name="ACCOUNT_CD")
    private String accountCd;
    @Column(name="ACCOUNT_NM")
    private String accountNm;
    @Column(name="ACCOUNT_NB")
    private String accountNb;
    @Column(name="ACCOUNT_ADD")
    private String accountAdd;
    @Column(name="ACCOUNT_REP")
    private String accountRep;
    @Column(name="ACCOUNT_SECTORS")
    private String accountSectors;
    @Column(name="ACCOUNT_BANK")
    private String accountBank;
    @Column(name="ACCOUNT_ACNB")
    private String accountAcnb;
    @Column(name="ACCOUNT_PIC")
    private String accountPic;
    @Column(name="ACCOUNT_ETC")
    private String accountEtc;

}
