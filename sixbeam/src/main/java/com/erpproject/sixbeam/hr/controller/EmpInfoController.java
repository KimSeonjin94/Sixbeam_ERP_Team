package com.erpproject.sixbeam.hr.controller;

import com.erpproject.sixbeam.hr.dto.EmpInfoDto;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public String updateEmployee(
            @RequestParam Long empInfoId,
            @RequestParam String empInfoPw,
            @RequestParam String empInfoNm,
            @RequestParam boolean empInfoSex,
            @RequestParam String empInfoBirth,
            @RequestParam String empInfoAddr,
            @RequestParam String empInfoPhone,
            @RequestParam String empInfoEmail,
            @RequestParam String empInfoJoinDt,
            @RequestParam String empInfoQuitDt,
//            @RequestParam String positionEntity,
//            @RequestParam String departEntity,
            @RequestParam String empInfoBank,
            @RequestParam String empInfoAccountNo,
            @RequestParam String empInfoQr,
            @RequestParam int empInfoTotalnoy,
            @RequestParam String empInfoEtc) {

        LocalDate birthDate = LocalDate.parse(empInfoBirth);
        LocalDate joinDate = LocalDate.parse(empInfoJoinDt);
        LocalDate quitDate = LocalDate.parse(empInfoQuitDt);


        empInfoService.updateEmployee(
                empInfoId, empInfoPw, empInfoNm, empInfoSex, birthDate, empInfoAddr, empInfoPhone, empInfoEmail,
                joinDate, quitDate, empInfoBank, empInfoAccountNo,
                empInfoQr, empInfoTotalnoy, empInfoEtc);

        return "contents/hr/empinfo_list"; // Redirect to the employee list page or any other appropriate page
    }
}




