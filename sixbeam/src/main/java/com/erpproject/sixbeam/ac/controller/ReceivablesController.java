package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.ac.service.ReceivablesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        Map<String, Object> suminput = receivablesService.sum_input_account();
//        suminput.get(code);



        return "contents/ac/receivables";
    }

}
