package com.erpproject.sixbeam.hr.controller;

import com.erpproject.sixbeam.hr.dto.EmpInfoDto;
import com.erpproject.sixbeam.hr.entity.DepartEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.PositionEntity;
import com.erpproject.sixbeam.hr.service.DepartService;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import javax.swing.text.Position;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/hr/empinfo")
@Controller
public class EmpInfoController {

    @Autowired
    private final EmpInfoService empInfoService;
    @Autowired
    private final DepartService departService;

    @GetMapping("/list")
    public String list(Model model) {
        List<EmpInfoEntity> employeeInfoList = this.empInfoService.getList();
        model.addAttribute("employeeInfoList", employeeInfoList);
        return "contents/hr/empinfo_list";
    }

    @GetMapping("/create")
    public String EmpInfoCreate() {
        return "contents/hr/form";
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
//            @RequestParam(value = "employeePosition",required = false)PositionEntity positionEntity,
//            @RequestParam(value = "employeeDepart",required = false)DepartEntity departEntity,
            @RequestParam(value = "employeeBank",required = false) String empInfoBank,
            @RequestParam(value = "employeeAccountNo",required = false) String empInfoAccountNo,
            @RequestParam(value = "employeeQr",required = false) String empInfoQr,
            @RequestParam(value = "employeeTotalnoy",required = false) int empInfoTotalnoy,
            @RequestParam(value = "employeeEtc",required = false) String empInfoEtc) {
        System.out.println("개글;!!!!!!!");
        System.out.println("개글;!!!!!!!");
        System.out.println("개글;!!!!!!!");
        System.out.println("개글;!!!!!!!");
        System.out.println("개글;!!!!!!!");
        System.out.println("개글;!!!!!!!");
        System.out.println("개글;!!!!!!!");
        System.out.println("개글;!!!!!!!");
        System.out.println("개글;!!!!!!!");
        System.out.println("개글;!!!!!!!");
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
//                positionEntity,
//                departEntity,
                empInfoBank,
                empInfoAccountNo,
                empInfoQr,
                empInfoTotalnoy,
                empInfoEtc);
        return "redirect:/hr/empinfo/list"; // Redirect to the employee list page or any other appropriate page
    }
}
