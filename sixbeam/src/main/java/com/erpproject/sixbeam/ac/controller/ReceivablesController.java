package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.ac.service.ReceivablesService;
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
public class ReceivablesController {

    private final AccountService accountService;
    private final ReceivablesService receivablesService;

    @GetMapping("/receivables/receivables")
    public String searchReceivables(Model model) {
        List<AccountEntity> actEntity = this.accountService.getList();
        model.addAttribute("actList", actEntity);
        return "contents/ac/receivables";
    }
    @GetMapping("/receivables/load")
    public ResponseEntity<?> inputAct(Model model,
            @RequestParam("accountCode") String accountCode,
            @RequestParam("accountName") String accountName,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate)
    {
        Map<String, Integer> suminput = receivablesService.sum_input_account(startDate,endDate);
        int receivablesSum = suminput.get(accountCode);
        int basicReceivables = 0;
        model.addAttribute("거래처명 코드", accountCode);
        model.addAttribute("거래처명", accountName);
        model.addAttribute("기초채권", basicReceivables);
        model.addAttribute("재고매출", receivablesSum);

        Map<String,Object> map =new HashMap<>();
        map.put("accountCode", accountCode);
        map.put("accountName", accountName);
        map.put("basicReceivables", basicReceivables);
        map.put("receivablesSum", receivablesSum);

        return ResponseEntity.ok().body(map);
    }

}
