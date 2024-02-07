package com.erpproject.sixbeam.ss.controller;

import com.erpproject.sixbeam.pd.dto.ItemDto;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.ss.dto.EstimateDto;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.service.EstimateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/ss/estimate")
@Controller
public class EstimateController {
    @Autowired
    private EstimateService estimateService;

    @GetMapping("/new")
    public String newEstimateDto(){
        return "contents/ss/estimate_form";
    }
    @PostMapping("/new")
    public  String newEstimateDto(@Valid EstimateDto estimateDto){
        return "redirect:contents/ss/estimate_list";
    }
    @GetMapping("/list")
    public String list(Model model){
        List< EstimateEntity> estimateEntities = estimateService.getList();
        model.addAttribute("estimateEntities",estimateEntities);
        return "contents/ss/estimate_list";
    }
    @GetMapping(value = "/list/detail/{id}")
    public String detail(Model model, @PathVariable("id") String id){
        List<EstimateEntity> estimateEntities = estimateService.getIdList(id);
        return "";
    }

    @GetMapping("/getitemdata")
    public Optional<ItemEntity> itemlist(Model model, @RequestParam String itemCd){

        return estimateService.getItemCd(itemCd);
    }

}