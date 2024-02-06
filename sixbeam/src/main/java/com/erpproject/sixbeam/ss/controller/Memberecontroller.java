package com.erpproject.sixbeam.ss.controller;

import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.service.MemberService;
import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/ss/member")
@Controller
public class Memberecontroller {
    @Autowired
    private MemberService memberService;

    @GetMapping("/new")
    public String newEstimateDto(){
        return "contents/ss/estimate_form";
    }
    @GetMapping("/list")
    public String list(Model model){
//        List<ManagedEntity> MemberEntities = this.memberService;
//        model.addAttribute("estimateEntities",MemberEntities);
        return "contents/ss/estimate_list";
    }
    @GetMapping(value = "/list/detail/{id}")
    public String detail(Model model, @PathVariable("id") String id){

        return "";
    }
}
