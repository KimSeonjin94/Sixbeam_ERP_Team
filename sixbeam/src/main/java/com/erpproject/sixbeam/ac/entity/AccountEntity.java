package com.erpproject.sixbeam.ac.entity;

import com.erpproject.sixbeam.ac.dto.AccountDto;
import jakarta.persistence.*;

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
    @Column(name="ACCOUNT_CD" ,nullable = false)
    private String accountCd;
    @Column(name="ACCOUNT_NM" ,nullable = false)
    private String accountNm;
    @Column(name="ACCOUNT_NB" ,nullable = false)
    private String accountNb;
    @Column(name="ACCOUNT_ADD" ,nullable = false)
    private String accountAdd;
    @Column(name="ACCOUNT_REP" ,nullable = false)
    private String accountRep;
    @Column(name="ACCOUNT_SECTORS" ,nullable = false)
    private String accountSectors;
    @Column(name="ACCOUNT_BANK" ,nullable = false)
    private String accountBank;
    @Column(name="ACCOUNT_ACNB" ,nullable = false)
    private String accountAcnb;
    @Column(name="ACCOUNT_PIC" ,nullable = false)
    private String accountPic;
    @Column(name="ACCOUNT_ETC")
    private String accountEtc;

    public void updateEntity(AccountDto accountDto) {
        this.accountCd = accountDto.getAccountCd();
        this.accountNm = accountDto.getAccountNm();
        this.accountNb = accountDto.getAccountNb();
        this.accountAdd = accountDto.getAccountAdd();
        this.accountRep = accountDto.getAccountRep();
        this.accountSectors = accountDto.getAccountSectors();
        this.accountBank = accountDto.getAccountBank();
        this.accountAcnb = accountDto.getAccountAcnb();
        this.accountPic = accountDto.getAccountPic();
        this.accountEtc = accountDto.getAccountEtc();
    }

}
