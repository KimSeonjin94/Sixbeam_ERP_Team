package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.entity.BsEntity;
import com.erpproject.sixbeam.ac.service.BsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/ac")
@Controller
public class BsController {

    private final BsService bsService;

    @GetMapping("/bs/balanceSheet")
    public String getBalanceSheet(@RequestParam(name="bsDtForm", required = false) String bsDt , Model model) {
        if (bsDt != null && !bsDt.isEmpty()) {
            BsEntity balanceSheet = bsService.findBalanceSheetByBsDt(bsDt);
            model.addAttribute("balanceSheet", balanceSheet);
        }
        List<String> bsDtList = bsService.findAllBsDts();
        model.addAttribute("bsDts", bsDtList);
//        model.addAttribute("selectedBsDt", bsDtForm);

        return "contents/ac/balance_sheet";
    }

}
