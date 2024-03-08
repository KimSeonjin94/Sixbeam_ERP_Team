package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.SalesDto;
import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.entity.SalesEntity;
import com.erpproject.sixbeam.ac.repository.SalesRepository;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.ss.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/ac")
public class SalesController {
    private final AccountService accountService;

//    @Autowired
//    private SalesRepository salesRepository;
//    @Autowired
//    private SaleService saleService;
//    @Autowired
//    private ApplicationEventPublisher event;

    @GetMapping("/sales/salesSlip")
    public String salesSlipForm(Model model) {
        List<AccountEntity> actEntity = this.accountService.getList();
        model.addAttribute("actList", actEntity);
        return "contents/ac/sales_slip";
    }


}
