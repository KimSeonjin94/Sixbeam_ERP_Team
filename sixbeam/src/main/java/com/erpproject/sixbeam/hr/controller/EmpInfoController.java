package com.erpproject.sixbeam.hr.controller;



import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/hr")
@Controller
public class EmpInfoController {
    private final EmpInfoService empInfoService;
    @GetMapping("/EmpInfo_list")
    public String list(Model model) {
        List<EmpInfoEntity> employeeInfoList = this.empInfoService.getList();
        model.addAttribute("employeeInfoList", employeeInfoList);
        return "Contents/HR/EmpInfo_list";
    }

    @GetMapping("/EmpInfo_create")
    public String EmpInfoCreate() {
        return "Contents/HR/EmpInfo_Form";
    }
}
