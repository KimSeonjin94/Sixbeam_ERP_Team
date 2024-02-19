package com.erpproject.sixbeam.ss.controller;

import com.erpproject.sixbeam.ss.dto.EstimateDto;
import com.erpproject.sixbeam.ss.dto.SaleDto;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.form.EstimateForm;
import com.erpproject.sixbeam.ss.service.EstimateService;
import com.erpproject.sixbeam.ss.service.SaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/ss/sale")
@Controller
@Slf4j
public class SaleController {
    @Autowired
    private SaleService saleService;
    @Autowired
    private EstimateService estimateService;

    public String create(@ModelAttribute SaleDto saleDto) {
        saleService.create(saleDto);
        return "redirect:/ss/sale/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<SaleEntity> saleEntities = saleService.getList();
        List<EstimateEntity> estimateEntities = estimateService.getList();
        model.addAttribute("estimateEntites", estimateEntities);
        model.addAttribute("saleEntities", saleEntities);
        return "contents/ss/sale_list";
    }

    @GetMapping("/new")
    public String create(Model model) {
        SaleDto saleDto = new SaleDto();
        List<EstimateEntity> estimateEntities = estimateService.getList();
        model.addAttribute("estimateEntities", estimateEntities);
        model.addAttribute("saleDto", saleDto);
        return "contents/ss/sale_form";
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEstimateDto(@ModelAttribute SaleDto saleDto) {
        try {
            this.saleService.create(saleDto);
            return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/ss/sale/list"));
        }catch (Exception e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/ss/sale/new");
            return ResponseEntity.badRequest().body(errorResponse);

        }
    }


}
