package com.erpproject.sixbeam.hr.controller;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/sixbeam")
@Controller
public class EmpInfoController {

    @Autowired
    private final EmpInfoService empInfoService;

    @GetMapping("/hr/EmpInfo_list")
    public String list(Model model) {
        List<EmpInfoEntity> employeeInfoList = this.empInfoService.getList();
        model.addAttribute("employeeInfoList", employeeInfoList);
        return "contents/hr/EmpInfo_list";
    }

    @GetMapping("/EmpInfo_create")
    public String EmpInfoCreate() {
        return "contents/hr/EmpInfo_Form";
    }

    @GetMapping("/api/employee/{empInfoId}")
    public EmpInfoEntity getEmployeeById(@PathVariable Long empInfoId) {
        return empInfoService.getEmployeeById(empInfoId);
    }
}
