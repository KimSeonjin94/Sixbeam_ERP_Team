package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.AccountDto;
import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import com.erpproject.sixbeam.ac.repository.IsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ac")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;


}
