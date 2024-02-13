package com.erpproject.sixbeam.hr.controller;


import com.erpproject.sixbeam.hr.entity.SalaryIdEntity;
import com.erpproject.sixbeam.hr.service.SalaryIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/hr/salaryId")
@Controller
public class SalaryIdController {
    @Autowired
    private final SalaryIdService salaryIdService;
    @GetMapping("/list")
    public String list(Model model){
        List<SalaryIdEntity>salaryIdList = this.salaryIdService.getList();
        model.addAttribute("salaryIdList",salaryIdList);
        return "contents/hr/salaryId_list";
    }
}
