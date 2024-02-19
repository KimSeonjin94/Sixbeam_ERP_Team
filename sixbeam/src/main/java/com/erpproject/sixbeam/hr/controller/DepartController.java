package com.erpproject.sixbeam.hr.controller;

import com.erpproject.sixbeam.hr.entity.DepartEntity;
import com.erpproject.sixbeam.hr.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/hr/depart")
@Controller


public class DepartController {
    @Autowired
    private final DepartService departService;
    @GetMapping("/list")
    public String list(Model model){
        List<DepartEntity> departList = this.departService.getList();
        model.addAttribute("departList",departList);
        return "contents/hr/depart_list";
    }
    @PostMapping("/update")
    public String update(@RequestParam(value ="departCd",required = false)Long departCd,
                         @RequestParam(value ="departNm",required = false)String departNm){
        this.departService.updateDepart(departCd, departNm);
        return "redirect:/hr/depart/list";
    }
    @PostMapping("/create")
    public String create(@RequestParam(value ="createDepartNm",required = false)String departNm){
        this.departService.createDepart(departNm);
        return "redirect:/hr/depart/list";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "selectedDeparts") List<Long> departCd){
        departService.deleteDepart(departCd);
        return "redirect:/hr/depart/list";
    }
    //ㅋㅋㅋㅋㅋ
}
