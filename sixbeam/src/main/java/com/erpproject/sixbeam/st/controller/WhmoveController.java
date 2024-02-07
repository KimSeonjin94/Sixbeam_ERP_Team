package com.erpproject.sixbeam.st.controller;

import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.service.WhmoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/st/whmove")
public class WhmoveController {

    private final WhmoveService whmoveService;
    @GetMapping("/")
    public String root() {return "redirect:/sixbeam/home";}
    @GetMapping("/list")
    public String list(Model model) {
        List<WhmoveEntity> whmoveEntityList = this.whmoveService.getList();
        model.addAttribute("whmoveEntityList",whmoveEntityList);
        return "contents/st/whmove_list";
    }
    @GetMapping(value = "/detail/{whmoveCd}")
    public String detail(Model model, @PathVariable("whmoveCd") String whmoveCd) {
        WhmoveEntity whmoveEntity = this.whmoveService.getWhmoveEntity(whmoveCd);
        model.addAttribute("whmoveEntity", whmoveEntity);
        return "contents/st/whmove_detail";
    }
}
