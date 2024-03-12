package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.SalesDto;
import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.ac.service.SalesService;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> saveSalesSlip(@ModelAttribute SalesDto salesDto) {
        Map<String, Object> Response = null;
        try {
            salesService.saveSalesSLip(salesDto);
            Response = new HashMap<>();
            Response.put("status", "success");
            Response.put("message", "정상적으로 저장되었습니다.");
            Response.put("redirectUrl", "/ac/sales/salesSlip");
            return ResponseEntity.ok().body(Response);
        } catch (Exception e) {
            Response = new HashMap<>();
            Response.put("status", "error");
            Response.put("message", String.format("저장에 실패 하였습니다.[%s]", e.getMessage()));
            Response.put("redirectUrl", "/ac/sales/salesSlip");
            return ResponseEntity.badRequest().body(Response);
        }

    }
}
