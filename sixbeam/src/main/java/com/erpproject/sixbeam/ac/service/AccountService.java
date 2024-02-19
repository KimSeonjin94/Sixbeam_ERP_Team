package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.dto.AccountDto;
import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    AccountEntity accountEntity;

    public List<AccountEntity> getList() {
        return this.accountRepository.findAll(); }

    public void saveAccount(AccountDto accountDto) {
        accountEntity = accountDto.toEntity();
        accountRepository.save(accountEntity);
    }

    public AccountEntity updateAccount(AccountDto accountDto) {

        AccountEntity editAccountEntity = accountDto.toEntity();

        accountEntity = accountRepository.findById(editAccountEntity.getAccountCd())
                .orElseThrow(() -> new IllegalArgumentException("Invalid account Id:" + editAccountEntity.getAccountCd()));

        accountEntity.setAccountCd(editAccountEntity.getAccountCd());
        accountEntity.setAccountNm(editAccountEntity.getAccountNm());
        accountEntity.setAccountNb(editAccountEntity.getAccountNb());
        accountEntity.setAccountAdd(editAccountEntity.getAccountAdd());
        accountEntity.setAccountRep(editAccountEntity.getAccountRep());
        accountEntity.setAccountSectors(editAccountEntity.getAccountSectors());
        accountEntity.setAccountBank(editAccountEntity.getAccountBank());
        accountEntity.setAccountAcnb(editAccountEntity.getAccountAcnb());
        accountEntity.setAccountPic(editAccountEntity.getAccountPic());
        accountEntity.setAccountEtc(editAccountEntity.getAccountEtc());

        return accountRepository.save(accountEntity);
    }
}



