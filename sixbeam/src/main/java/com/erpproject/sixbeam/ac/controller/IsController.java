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
            // 해당 년도의 데이터를 찾아 incomeStatement 엔티티에 반영
            // 손익계산서 항목들 계산
            IsEntity incomeStatement = isService.findIncomeStatementByIsDt(isDt);
            model.addAttribute("incomeStatement", incomeStatement);

            incomeStatement.setIsCostSales((long) (incomeStatement.getIsNetSales() / 1.1));

            long grossProfit = incomeStatement.getIsNetSales() - incomeStatement.getIsCostSales();
            model.addAttribute("grossProfit", grossProfit);

            long operatingExpenses = incomeStatement.getIsWages();
            model.addAttribute("operatingExpenses", operatingExpenses);

            long operatingIncome = grossProfit - operatingExpenses;
            model.addAttribute("operatingIncome", operatingIncome);

            long nonOperatingIncome = incomeStatement.getIsInterInc();
            model.addAttribute("nonOperatingIncome", nonOperatingIncome);

            long nonOperatingExpenses = incomeStatement.getIsInterExp();
            model.addAttribute("nonOperatingExpenses", nonOperatingExpenses);

            long earningBeforeTaxes = operatingIncome + nonOperatingIncome - nonOperatingExpenses;
            model.addAttribute("earningBeforeTaxes", earningBeforeTaxes);

            incomeStatement.setIsCortaxExp((int) (earningBeforeTaxes * 0.1));

            long netIncome = earningBeforeTaxes - incomeStatement.getIsCortaxExp();
            model.addAttribute("netIncome", netIncome);

        }

        // 모든 년도를 담은 리스트를 모델에 추가
        // 선택한 년도가 그대로 유지되도록
        List<String> isDtList = isService.findAllIsDts();
        model.addAttribute("isDts", isDtList);
        model.addAttribute("selectedIsDt", isDt);

        return "contents/ac/income_statement.html";
    }

}




