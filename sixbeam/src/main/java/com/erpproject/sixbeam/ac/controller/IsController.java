package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.entity.IsEntity;
import com.erpproject.sixbeam.ac.service.IsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/ac")
public class IsController {

    private final IsService isService;

    @GetMapping("/is/incomeStatement")
    public String getIncomeStatement(@RequestParam(name="isDtForm", required = false) String isDt , Model model) {
        if (isDt != null && !isDt.isEmpty()) {
            isService.updateIsNetSales(isDt);
            IsEntity incomeStatement = isService.findIncomeStatementByIsDt(isDt);
            model.addAttribute("incomeStatement", incomeStatement);

            Integer grossProfit = incomeStatement.getIsNetSales() - incomeStatement.getIsCostSales();
            model.addAttribute("grossProfit", grossProfit);

            Integer operatingExpenses = incomeStatement.getIsWages();
            model.addAttribute("operatingExpenses", operatingExpenses);

            Integer operatingIncome = grossProfit - operatingExpenses;
            model.addAttribute("operatingIncome", operatingIncome);

            Integer nonOperatingIncome = incomeStatement.getIsInterInc();
            model.addAttribute("nonOperatingIncome", nonOperatingIncome);

            Integer nonOperatingExpenses = incomeStatement.getIsInterExp();
            model.addAttribute("nonOperatingExpenses", nonOperatingExpenses);

            Integer earningBeforeTaxes = operatingIncome + nonOperatingIncome - nonOperatingExpenses;
            model.addAttribute("earningBeforeTaxes", earningBeforeTaxes);

            Integer netIncome = earningBeforeTaxes - incomeStatement.getIsCortaxExp();
            model.addAttribute("netIncome", netIncome);

        }
        List<String> isDtList = isService.findAllIsDts();
        model.addAttribute("isDts", isDtList);
        model.addAttribute("selectedIsDt", isDt);

        return "contents/ac/income_statement.html";
    }

}




