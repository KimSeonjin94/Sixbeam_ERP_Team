package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.AccountDto;
import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/account/edit")
    public String editAccount(@ModelAttribute AccountDto accountDto) {
        accountService.updateAccount(accountDto);
        return "redirect:list";
    }

    @PostMapping("/account/delete")
    public String deleteAccount(@RequestParam(name = "accountCd") String accountCd) {
        accountService.deleteAccount(accountCd);
        return "redirect:list";
    }

    @PostMapping("/account/registerform")
    public String registerAccountByPage(@ModelAttribute AccountDto accountDto) {
        accountService.saveAccount(accountDto);
        return "redirect:registerform";
    }
}
