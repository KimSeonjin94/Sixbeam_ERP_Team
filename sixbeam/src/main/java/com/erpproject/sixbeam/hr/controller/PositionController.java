package com.erpproject.sixbeam.hr.controller;

import com.erpproject.sixbeam.hr.entity.PositionEntity;
import com.erpproject.sixbeam.hr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/hr/position")
@Controller


public class PositionController {
    @Autowired
    private final PositionService positionService;
    @GetMapping("/list")
    public String list(Model model){
        List<PositionEntity> positionList = this.positionService.getList();
        model.addAttribute("positionList",positionList);
        return "contents/hr/position_list";
    }
    @PostMapping("/update")
    public String update(@RequestParam(value ="positionCd",required = false)Long positionCd,
                         @RequestParam(value ="positionNm",required = false)String positionNm){
        this.positionService.updatePosition(positionCd, positionNm);
        return "redirect:/hr/position/list";
    }
    @PostMapping("/create")
    public String create(@RequestParam(value ="createPositionNm",required = false)String positionNm){
        this.positionService.createPosition(positionNm);
        return "redirect:/hr/position/list";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "selectedPositions") Long positionCd){
        positionService.deletePosition(positionCd);
        return "redirect:/hr/position/list";
    }
}

