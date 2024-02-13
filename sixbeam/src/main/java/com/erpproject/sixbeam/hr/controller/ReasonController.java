package com.erpproject.sixbeam.hr.controller;


import com.erpproject.sixbeam.hr.entity.ReasonEntity;
import com.erpproject.sixbeam.hr.service.ReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/hr/reason")
@Controller


public class ReasonController {
    @Autowired
    private final ReasonService reasonService;
    @GetMapping("/list")
    public String list(Model model){
        List<ReasonEntity> reasonList = this.reasonService.getList();
        model.addAttribute("reasonList",reasonList);
        return "contents/hr/reason_list";
    }
    @PostMapping("/update")
    public String update(@RequestParam(value ="reasonCd",required = false)Long reasonCd,
                         @RequestParam(value ="reasonNm",required = false)String reasonNm){
        this.reasonService.updateReason(reasonCd, reasonNm);
        return "redirect:/hr/reason/list";
    }
    @PostMapping("/create")
    public String create(@RequestParam(value ="createReasonNm",required = false)String reasonNm){
        this.reasonService.createReason(reasonNm);
        return "redirect:/hr/reason/list";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "selectedReasons") Long reasonCd){
        reasonService.deleteReason(reasonCd);
        return "redirect:/hr/reason/list";
    }
}



