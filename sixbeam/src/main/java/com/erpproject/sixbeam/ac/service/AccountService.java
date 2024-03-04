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
    // 레포지토리를 사용하기 위해 선언

    AccountEntity accountEntity;

    public List<AccountEntity> getList() {
        return this.accountRepository.findAll();
        // 레포지토리의 모든 요소를 가져와서 리스트 형태로 반환한다.
    }

    public void saveAccount(AccountDto accountDto) {
        accountEntity = accountDto.toEntity();
        // 매개변수로 받은 accountDto를 엔티티로 변환하여 대입
        accountRepository.save(accountEntity);
        // 변환된 accountEntity를 레포지토리에 저장한다.
    }

    public AccountEntity updateAccount(AccountDto accountDto) {

        AccountEntity editAccountEntity = accountDto.toEntity();
        // 매개변수로 받은 accountDto를 엔티티로 변환

        accountEntity = accountRepository.findById(editAccountEntity.getAccountCd())
                .orElseThrow(() -> new IllegalArgumentException("Invalid account Id:" + editAccountEntity.getAccountCd()));
        // 엔티티에서 getAccountCd하여 비교하여 찾는다.
        // accountEntity에 editAccountEntity에 저장되어 있던 요소들을 set한다.
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
        // 변경된 accountEntity를 레포지토리에 저장한다.
    }
    @Transactional
    public void deleteAccount(String accountCd) {
        accountRepository.findById(accountCd).ifPresent(accountRepository::delete);
        // 매개변수로 받은 accountCd를 기준으로 레포지토리에서 검색
        // 만약 존재하면 레포지토리에서 삭제한다.
    }

}



