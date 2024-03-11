package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.PurDto;
import com.erpproject.sixbeam.ac.dto.SalesDto;
import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.entity.SalesEntity;
import com.erpproject.sixbeam.ac.repository.SalesRepository;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.ac.service.SalesService;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/ac")
public class SalesController {
    private final AccountService accountService;


    private final SalesService salesService;

    private final ApplicationEventPublisher event;

    @GetMapping("/sales/salesSlip")
    public String salesSlipForm(Model model) {
        List<AccountEntity> actEntity = this.accountService.getList();
        List<SaleEntity> saleEntities = this.salesService.getSaleList();
        model.addAttribute("actList", actEntity);
        model.addAttribute("saleEntities", saleEntities);
        return "contents/ac/sales_slip";
    }

    @PostMapping("/sales/salesSlip")
    public String saveSalesSlip(@ModelAttribute SalesDto salesDto) {

        salesService.saveSalesSLip(salesDto);
        return "redirect:salesSlip";
    }
}
