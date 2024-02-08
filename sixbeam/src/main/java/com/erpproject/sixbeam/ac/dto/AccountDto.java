package com.erpproject.sixbeam.ac.dto;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {
    private String accountCd;
    private String accountNm;
    private String accountNb;
    private String accountAdd;
    private String accountRep;
    private String accountSectors;
    private String accountBank;
    private String accountAcnb;
    private String accountPic;
    private String accountEtc;

    public AccountEntity toEntity() {

//        AccountEntity accountEntity = new AccountEntity();
//
//        accountEntity.setAccountCd(accountCd);
//        accountEntity.setAccountNm(accountNm);
//        accountEntity.setAccountNb(accountNb);
//        accountEntity.setAccountAdd(accountAdd);
//        accountEntity.setAccountRep(accountRep);
//        accountEntity.setAccountSectors(accountSectors);
//        accountEntity.setAccountBank(accountBank);
//        accountEntity.setAccountAcnb(accountAcnb);
//        accountEntity.setAccountPic(accountPic);
//        accountEntity.setAccountEtc(accountEtc);
//
//        return accountEntity;

        return new AccountEntity(accountCd, accountNm, accountNb, accountAdd, accountRep, accountSectors, accountBank, accountAcnb, accountPic, accountEtc);

    }
}
