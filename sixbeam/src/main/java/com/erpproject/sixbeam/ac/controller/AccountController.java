package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.AccountDto;
import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/ac")
@Controller
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/account/list")
    public String getAccountList(Model model) {
        List<AccountEntity> accountList = this.accountService.getList();
        model.addAttribute("accountList",accountList);
        return "contents/ac/account_list";
    }
    @PostMapping("/account/register")
    public String registerAccount(@ModelAttribute AccountDto accountDto) {
        accountService.saveAccount(accountDto);
        return "redirect:list";
    }

    @PostMapping("/account/registerform")
    public String registerAccountByPage(@ModelAttribute AccountDto accountDto) {
        accountService.saveAccount(accountDto);
        return "redirect:registerform";
    }

    @PostMapping("/account/edit")
    public String editAccount(@ModelAttribute AccountDto accountDto) {
        accountService.updateAccount(accountDto);
        return "redirect:list";
    }



}
