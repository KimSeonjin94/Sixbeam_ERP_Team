package com.erpproject.sixbeam.hr.controller;


import com.erpproject.sixbeam.hr.entity.DepartEntity;
import com.erpproject.sixbeam.hr.entity.PositionEntity;
import com.erpproject.sixbeam.hr.entity.SalaryIdEntity;
import com.erpproject.sixbeam.hr.service.DepartService;
import com.erpproject.sixbeam.hr.service.PositionService;
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
    @Autowired
    private final DepartService departService;
    @Autowired
    private final PositionService positionService;
    @GetMapping("/list")
    public String list(Model model){
        List<SalaryIdEntity> salaryIdList = this.salaryIdService.getList();
        model.addAttribute("salaryIdList",salaryIdList);
        List<DepartEntity> departList = this.departService.getList();
        model.addAttribute("departList",departList);
        List<PositionEntity> positionList = this.positionService.getList();
        model.addAttribute("positionList",positionList);
        return "contents/hr/salaryId_list";
    }
    @PostMapping("/update")
    public String update(@RequestParam(value ="salaryIdCd",required = false)Long salaryIdCd,
                         @RequestParam(value ="departCd",required = false)DepartEntity departCd,
                         @RequestParam(value ="positionCd",required = false)PositionEntity positionCd,
                         @RequestParam(value ="basicSalary",required = false)int basicSalary){
        this.salaryIdService.updateSalaryId(salaryIdCd, departCd,positionCd,basicSalary);
        return "redirect:/hr/salaryId/list";
    }
    @PostMapping("/create")
    public String create(@RequestParam(value ="createDepartCd",required = false)DepartEntity departCd,
                         @RequestParam(value ="createPositionCd",required = false)PositionEntity positionCd,
                         @RequestParam(value ="createBasicSalary",required = false)int basicSalary){
        this.salaryIdService.createSalaryId(departCd,positionCd,basicSalary);
        return "redirect:/hr/salaryId/list";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "selectedSalaryIds") List<Long> salaryIdCd){
        salaryIdService.deleteSalaryId(salaryIdCd);
        return "redirect:/hr/salaryId/list";
    }
}
