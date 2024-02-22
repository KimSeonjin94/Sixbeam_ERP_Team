package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.entity.BsEntity;
import com.erpproject.sixbeam.ac.service.BsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/ac")
@Controller
public class BsController {

    private final BsService bsService;

    @GetMapping("/bs/balanceSheet")
    public String getBalanceSheet(Model model) {
        List<BsEntity> balanceSheet = this.bsService.getList();
        model.addAttribute("balanceSheet", balanceSheet);
        return "contents/ac/balance_sheet";
    }

}
