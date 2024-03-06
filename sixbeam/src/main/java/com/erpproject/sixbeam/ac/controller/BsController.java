package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.entity.BsEntity;
import com.erpproject.sixbeam.ac.service.BsService;
import com.erpproject.sixbeam.ac.service.PayablesService;
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
    private final PayablesService payablesService;

    @GetMapping("/bs/balanceSheet")
    public String getBalanceSheet(@RequestParam(name="bsDtForm", required = false) String bsDt , Model model) {
        if (bsDt != null && !bsDt.isEmpty()) {

            BsEntity balanceSheet = bsService.findBalanceSheetByBsDt(bsDt);
            bsService.updateBsReceivables(bsDt);
            model.addAttribute("balanceSheet", balanceSheet);

            Integer totalAsset = balanceSheet.getBsCash() + balanceSheet.getBsInventories()
                    + balanceSheet.getBsReceivables() + balanceSheet.getBsLand()
                    + balanceSheet.getBsBuilding() + balanceSheet.getBsFac();
            model.addAttribute("totalAsset", totalAsset);

            Integer totalDebt = balanceSheet.getBsLongBor() + balanceSheet.getBsPayables();
            model.addAttribute("totalDebt", totalDebt);

            Integer totalCapital = balanceSheet.getBsCapital() + balanceSheet.getBsEarnings();
            model.addAttribute("totalCapital", totalCapital);
            payablesService.payables_by_year(bsDt);
        }

        List<String> bsDtList = bsService.findAllBsDts();
        model.addAttribute("bsDts", bsDtList);
        model.addAttribute("selectedBsDt", bsDt);

        return "contents/ac/balance_sheet";
    }

}
