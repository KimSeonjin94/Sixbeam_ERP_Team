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
        // 선택한 년도를 비교하여
        if (bsDt != null && !bsDt.isEmpty()) {
            bsService.updateBsInventoriesByYear(bsDt);      //재고자산 계산
            // 선택한 년도에 맞는 데이터를 서비스에서 찾아 BS엔티티에 넣는다.
            BsEntity balanceSheet = bsService.findBalanceSheetByBsDt(bsDt);
            bsService.updateBsReceivables(bsDt);
            // balanceSheet 엔티티의 요소들을 뷰에 넘긴다.
            model.addAttribute("balanceSheet", balanceSheet);

            // 자산(차변) 계산
            long totalAsset = balanceSheet.getBsCash() + balanceSheet.getBsInventories()
                    + balanceSheet.getBsReceivables() + balanceSheet.getBsLand()
                    + balanceSheet.getBsBuilding() + balanceSheet.getBsFac();
            model.addAttribute("totalAsset", totalAsset);

            // 부채(대변) 계산
            long totalDebt = balanceSheet.getBsLongBor() + balanceSheet.getBsPayables();
            model.addAttribute("totalDebt", totalDebt);

            // 자본(대변) 계산
            long totalCapital = balanceSheet.getBsCapital() + balanceSheet.getBsEarnings();
            model.addAttribute("totalCapital", totalCapital);
            payablesService.payables_by_year(bsDt);
        }
        // 모든 년도를 담은 리스트를 모델에 추가
        // 선택한 년도가 그대로 유지되도록
        List<String> bsDtList = bsService.findAllBsDts();
        model.addAttribute("bsDts", bsDtList);
        model.addAttribute("selectedBsDt", bsDt);

        return "contents/ac/balance_sheet";
    }

}
