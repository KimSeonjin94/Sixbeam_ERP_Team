package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.AccountDto;
import com.erpproject.sixbeam.ac.repository.BsRepository;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.ac.service.BsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/ac")
@Controller
public class BsController {

    private final BsService bsService;

    @GetMapping("/bs/balanceSheet")
    public String getRegisterAccountForm(Model model) {
        return "contents/ac/balance_sheet";
    }
//    @PostMapping("/bs/balanceSheet")
//    public String registerAccountByPage(@ModelAttribute AccountDto accountDto) {
//        return "redirect:registerform";
//    }

}
