package com.erpproject.sixbeam.hr.controller;


import com.erpproject.sixbeam.hr.entity.DepartEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.PositionEntity;
import com.erpproject.sixbeam.hr.service.DepartService;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import com.erpproject.sixbeam.hr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/hr/empinfo")
@Controller
public class EmpInfoController {

    @Autowired
    private final EmpInfoService empInfoService;
    @Autowired
    private final DepartService departService;
    @Autowired
    private final PositionService positionService;
    @GetMapping("/list")
    public String list(Model model) {
        List<EmpInfoEntity> employeeInfoList = this.empInfoService.getList();
        model.addAttribute("employeeInfoList", employeeInfoList);
        List<DepartEntity>departList = this.departService.getList();
        model.addAttribute("departList",departList);
        List<PositionEntity>positionList = this.positionService.getList();
        model.addAttribute("positionList",positionList);
        return "contents/hr/empinfo_list";
    }
    @PostMapping("/update")
    public String update(
            @RequestParam(value = "employeeId") Long empInfoId,
            @RequestParam(value = "employeePassword",required = false) String empInfoPw,
            @RequestParam(value = "employeeName",required = false) String empInfoNm,
            @RequestParam(value = "employeeSex",required = false) boolean empInfoSex,
            @RequestParam(value = "employeeBirth",required = false)LocalDate empInfoBirth,
            @RequestParam(value = "employeeAddr",required = false) String empInfoAddr,
            @RequestParam(value = "employeePhone",required = false) String empInfoPhone,
            @RequestParam(value = "employeeEmail",required = false) String empInfoEmail,
            @RequestParam(value = "employeeJoinDt",required = false)LocalDate empInfoJoinDt,
            @RequestParam(value = "employeeQuitDt",required = false)LocalDate empInfoQuitDt,
            @RequestParam(value = "positionCd",required = false)PositionEntity positionCd,
            @RequestParam(value = "departCd",required = false)DepartEntity departCd,
            @RequestParam(value = "employeeBank",required = false) String empInfoBank,
            @RequestParam(value = "employeeAccountNo",required = false) String empInfoAccountNo,
            @RequestParam(value = "employeeQr",required = false) String empInfoQr,
            @RequestParam(value = "employeeTotalnoy",required = false) int empInfoTotalnoy,
            @RequestParam(value = "employeeEtc",required = false) String empInfoEtc) {
        this.empInfoService.updateEmployee(
                empInfoId,
                empInfoPw,
                empInfoNm,
                empInfoSex,
                empInfoBirth,
                empInfoAddr,
                empInfoPhone,
                empInfoEmail,
                empInfoJoinDt,
                empInfoQuitDt,
                positionCd,
                departCd,
                empInfoBank,
                empInfoAccountNo,
                empInfoQr,
                empInfoTotalnoy,
                empInfoEtc);
        return "redirect:/hr/empinfo/list"; // Redirect to the employee list page or any other appropriate page
    }
    @PostMapping("/create")
    public String create(
            @RequestParam(value = "createEmployeeName",required = false) String empInfoNm,
            @RequestParam(value = "createEmployeePassword",required = false) String empInfoPw,
            @RequestParam(value = "createEmployeeSex",required = false) boolean empInfoSex,
            @RequestParam(value = "createEmployeeBirth",required = false) LocalDate empInfoBirth,
            @RequestParam(value = "createEmployeeAddr",required = false) String empInfoAddr,
            @RequestParam(value = "createEmployeePhone",required = false) String empInfoPhone,
            @RequestParam(value = "createEmployeeEmail",required = false) String empInfoEmail,
            @RequestParam(value = "createEmployeeJoinDt",required = false) LocalDate empInfoJoinDt,
            @RequestParam(value = "createEmployeeQuitDt",required = false) LocalDate empInfoQuitDt,
            @RequestParam(value = "createEmployeePosition",required = false) PositionEntity positionCd,
            @RequestParam(value = "createEmployeeDepart",required = false) DepartEntity departCd,
            @RequestParam(value = "createEmployeeBank",required = false) String empInfoBank,
            @RequestParam(value = "createEmployeeAccountNo",required = false) String empInfoAccountNo,
            @RequestParam(value = "createEmployeeQr",required = false) String empInfoQr,
            @RequestParam(value = "createEmployeeTotalnoy",required = false) int empInfoTotalnoy,
            @RequestParam(value = "createEmployeeEtc",required = false) String empInfoEtc
    ) {
        this.empInfoService.createEmployee(
                empInfoPw,
                empInfoNm,
                empInfoSex,
                empInfoBirth,
                empInfoAddr,
                empInfoPhone,
                empInfoEmail,
                empInfoJoinDt,
                empInfoQuitDt,
                positionCd,
                departCd,
                empInfoBank,
                empInfoAccountNo,
                empInfoQr,
                empInfoTotalnoy,
                empInfoEtc);
        return "redirect:/hr/empinfo/list";
    }
    @PostMapping("/delete")
    public String delete( @RequestParam(value = "selectedEmployees")List<Long>empInfoId) {
        empInfoService.deleteEmployee(empInfoId);
        return "redirect:/hr/empinfo/list"; // Redirect to the employee list page or any other appropriate page
    }
}
