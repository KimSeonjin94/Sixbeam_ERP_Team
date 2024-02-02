package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public List<AccountEntity> getList() {
        return this.accountRepository.findAll(); }
}
