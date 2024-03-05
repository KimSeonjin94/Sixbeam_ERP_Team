package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.ac.service.PayablesService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/ac")
@Controller
public class PayablesController {

    private final AccountService accountService;
    private final PayablesService payablesService;

    @GetMapping("/payables/payables")
    public String searchReceivables(Model model) {
        List<AccountEntity> actEntity = this.accountService.getList();
        model.addAttribute("actList", actEntity);
        return "contents/ac/payables";
    }

    @GetMapping("/payables/load")
    public ResponseEntity<?> inputAct(Model model,
                                      @RequestParam("accountCode") String accountCode,
                                      @RequestParam("accountName") String accountName,
                                      @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                      @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate)
    {
        Map<String, Integer> suminput = payablesService.sum_input_account(startDate,endDate);
        int payablesSum = suminput.get(accountCode);
        int basicPayables = 0;
        int paidCash = 0;
        int paidSum = 0;
        int balance = basicPayables + payablesSum - paidSum;
        int unclaimedAmount = balance;
        String note = null;

//        model.addAttribute("거래처 코드", accountCode);
//        model.addAttribute("거래처명", accountName);
//        model.addAttribute("기초채무", basicPayables);
//        model.addAttribute("재고매입", payablesSum);
//        model.addAttribute("지급현금", paidCash);
//        model.addAttribute("지급합계", paidSum);
//        model.addAttribute("잔액", balance);
//        model.addAttribute("미청구액", unclaimedAmount);
//        model.addAttribute("비고", note);

        Map<String,Object> map =new HashMap<>();
        map.put("accountCode", accountCode);
        map.put("accountName", accountName);
        map.put("basicPayables", basicPayables);
        map.put("payablesSum", payablesSum);
        map.put("paidCash", paidCash);
        map.put("paidSum", paidSum);
        map.put("balance", balance);
        map.put("unclaimedAmount", unclaimedAmount);
        map.put("note", note);

        return ResponseEntity.ok().body(map);
    }

}
