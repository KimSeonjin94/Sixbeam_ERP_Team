package com.erpproject.sixbeam.ac.controller;


import com.erpproject.sixbeam.ac.dto.AccountDto;
import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import com.erpproject.sixbeam.ac.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/ac")
@Controller
public class AccountController {
    private final AccountService accountService;
    private AccountRepository accountRepository;
    @GetMapping("/account/list")
    public String list(Model model) {
        List<AccountEntity> accountList = this.accountService.getList();
        model.addAttribute("accountList",accountList);
        return "contents/ac/account_list";
    }

    @PostMapping("/account/form")
    public ModelAndView registerAccount(@ModelAttribute AccountDto accountDto)
        {
            AccountEntity accountEntity = new AccountEntity();

            accountEntity.setAccountCd(accountDto.getAccountCd());
            accountEntity.setAccountNm(accountDto.getAccountNm());
            accountEntity.setAccountNb(accountDto.getAccountNb());
            accountEntity.setAccountAdd(accountDto.getAccountAdd());
            accountEntity.setAccountRep(accountDto.getAccountRep());
            accountEntity.setAccountSectors(accountDto.getAccountSectors());
            accountEntity.setAccountBank(accountDto.getAccountBank());
            accountEntity.setAccountAcnb(accountDto.getAccountAcnb());
            accountEntity.setAccountPic(accountDto.getAccountPic());
            accountEntity.setAccountEtc(accountDto.getAccountEtc());

            accountRepository.save(accountEntity);

            return new ModelAndView("redirect:/account/form");
    }

}
