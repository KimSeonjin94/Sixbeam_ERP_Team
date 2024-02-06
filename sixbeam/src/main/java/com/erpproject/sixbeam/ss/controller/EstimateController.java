package com.erpproject.sixbeam.ss.controller;

import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.repository.EstimateRepository;
import com.erpproject.sixbeam.ss.service.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/ss/estimate")
@Controller
public class EstimateController {
    @Autowired
    private EstimateService estimateService;

    @GetMapping("/new")
    public String newEstimateDto(){
        return "contents/ss/estimate_form";
    }
    @GetMapping("/list")
    public String list(Model model){
        List< EstimateEntity> estimateEntities = this.estimateService.getList();
        model.addAttribute("estimateEntities",estimateEntities);
        return "contents/ss/estimate_list";
    }
    @GetMapping(value = "/list/detail/{id}")
    public String detail(Model model, @PathVariable("id") String id){
        List<EstimateEntity> estimateEntities = this.estimateService.getIdList(id);
        return "";
    }

}
