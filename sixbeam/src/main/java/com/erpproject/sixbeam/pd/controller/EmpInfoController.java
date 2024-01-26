package com.erpproject.sixbeam.pd.controller;


import com.erpproject.sixbeam.pd.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.service.EmpInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/hr")
@Controller
public class EmpInfoController {
    private final EmpInfoService empInfoService;
    @GetMapping("/EmpInfo_list")
    public String list(Model model) {
        List<EmpInfoEntity> EmpInfoList = this.empInfoService.getList();
        model.addAttribute("EmpInfoList",EmpInfoList);
        return "Contents/HR/EmpInfo_list";
    }

    @GetMapping("/EmpInfo_create")
    public String EmpInfoCreate() {
        return "Contents/HR/EmpInfo_Form";
    }
}
