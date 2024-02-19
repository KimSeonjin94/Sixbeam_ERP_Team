package com.erpproject.sixbeam.hr.controller;



import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.entity.SalaryEntity;
import com.erpproject.sixbeam.hr.entity.SalaryIdEntity;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import com.erpproject.sixbeam.hr.service.SalaryIdService;
import com.erpproject.sixbeam.hr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.time.YearMonth;
import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/hr/salary")
@Controller


public class SalaryController {
    @Autowired
    private final SalaryService salaryService;
    @Autowired
    private final EmpInfoService empInfoService;
    @Autowired
    private final SalaryIdService salaryIdService;
    @GetMapping("/list")
    public String list(Model model){
        List<SalaryEntity> salaryList = this.salaryService.getList();
        model.addAttribute("salaryList",salaryList);
        List<EmpInfoEntity> empInfoList = this.empInfoService.getList();
        model.addAttribute("empInfoList",empInfoList);
        List<SalaryIdEntity> salaryIdList = this.salaryIdService.getList();
        model.addAttribute("salaryIdList",salaryIdList);
        return "contents/hr/salary_list";
    }
    @PostMapping("/create")
    public String create(@RequestParam(value="salarySmonth",required = false)YearMonth salarySmonth,
                         @RequestParam(value="salaryIdCd",required = false)SalaryIdEntity salaryIdCd,
                         @RequestParam(value="empInfoId",required = false)EmpInfoEntity empInfoId,
                         @RequestParam(value="salaryBonus",required = false)int salaryBonus,
                         @RequestParam(value="salaryAllow",required = false)int salaryAllow,
                         @RequestParam(value="salaryIncentive",required = false)int salaryIncentive,
                         @RequestParam(value="salaryTtmoney",required = false)Integer salaryTtmoney){
        this.salaryService.createSalary(salarySmonth,
                salaryIdCd,
                empInfoId,
                salaryBonus,
                salaryAllow,
                salaryIncentive,
                salaryTtmoney
                );
        return "redirect:/hr/salary/list";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "selectedSalarys")List<Long> salaryCd){
        salaryService.deleteSalary(salaryCd);
        return "redirect:/hr/salary/list";
    }
    @PostMapping("/update")
    public String update(@RequestParam(value="modifySalaryCd")Long salaryCd,
                         @RequestParam(value="modifySalarySmonth",required = false)YearMonth salarySmonth,
                         @RequestParam(value="modifySalaryIdCd",required = false)SalaryIdEntity salaryIdCd,
                         @RequestParam(value="modifyEmpInfoId",required = false)EmpInfoEntity empInfoId,
                         @RequestParam(value="modifySalaryBonus",required = false)int salaryBonus,
                         @RequestParam(value="modifySalaryAllow",required = false)int salaryAllow,
                         @RequestParam(value="modifySalaryIncentive",required = false)int salaryIncentive,
                         @RequestParam(value="modifySalaryTtmoney",required = false)Integer salaryTtmoney){
        this.salaryService.updateSalary(
                salaryCd,
                salarySmonth,
                salaryIdCd,
                empInfoId,
                salaryBonus,
                salaryAllow,
                salaryIncentive,
                salaryTtmoney
                );
        return "redirect:/hr/salary/list";
    }



}
