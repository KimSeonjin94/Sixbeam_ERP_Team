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

    public List<AccountEntity> getList() {
        return this.accountRepository.findAll(); }

    public void saveAccount(AccountDto accountDto) {
        AccountEntity accountEntity = accountDto.toEntity();
        accountRepository.save(accountEntity);
    }
    @Transactional
    public void updateAccount(AccountDto editAccountDto) {
        AccountEntity accountEntity = editAccountDto.toEntity();
        accountRepository.save(accountEntity);
    }
//    @Transactional
//    public void updateAccount(AccountDto accountDto) {
//        AccountEntity accountEntity = accountRepository.findById(accountDto.getAccountCd())
//                .orElseThrow(() -> new EntityNotFoundException("Account not found"));
//        accountEntity.setAccountCd(accountDto.getAccountCd());
//        accountEntity.setAccountNm(accountDto.getAccountNm());
//        accountEntity.setAccountNb(accountDto.getAccountNb());
//        accountEntity.setAccountAdd(accountDto.getAccountAdd());
//        accountEntity.setAccountRep(accountDto.getAccountRep());
//        accountEntity.setAccountSectors(accountDto.getAccountSectors());
//        accountEntity.setAccountBank(accountDto.getAccountBank());
//        accountEntity.setAccountAcnb(accountDto.getAccountAcnb());
//        accountEntity.setAccountPic(accountDto.getAccountPic());
//        accountEntity.setAccountEtc(accountDto.getAccountEtc());
//        accountRepository.save(accountEntity);
//    }

}
