package com.erpproject.sixbeam.ac.controller;


import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/ac")
@Controller
public class AccountController {
    private final AccountService accountService;
    @GetMapping("/Account_List")
    public String list(Model model) {
        List<AccountEntity> accountList = this.accountService.getList();
        model.addAttribute("accountList",accountList);
        return "Contents/AC/Account_List";
    }

}
