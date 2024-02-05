package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequiredArgsConstructor
@Controller
@RequestMapping("/ac")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/Account")
    public String AccountCreate() {

        return "Contents/AC/Account_Form";
    }
}
