package com.erpproject.sixbeam.hr.controller;



import com.erpproject.sixbeam.hr.entity.EmployeeInfoEntity;
import com.erpproject.sixbeam.hr.service.EmployeeInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/hr")
@Controller
public class EmployeeInfoController {
    private final EmployeeInfoService employeeInfoService;
    @GetMapping("/EmpInfo_list")
    public String list(Model model) {
        List<EmployeeInfoEntity> employeeInfoList = this.employeeInfoService.getList();
        model.addAttribute("employeeInfoList",employeeInfoList);
        return "Contents/HR/EmpInfo_list";
    }

    @GetMapping("/EmpInfo_create")
    public String EmpInfoCreate() {
        return "Contents/HR/EmpInfo_Form";
    }
}
