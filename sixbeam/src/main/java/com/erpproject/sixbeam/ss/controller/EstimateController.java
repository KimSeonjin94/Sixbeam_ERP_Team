package com.erpproject.sixbeam.ss.controller;

import com.erpproject.sixbeam.ss.repository.EstimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ss/Estimate")
@Controller
public class EstimateController {
    @Autowired
    private EstimateRepository estimateRepository;

    @GetMapping("/new")
    public String newEstimateDto(){
        return "/new";
    }
}
