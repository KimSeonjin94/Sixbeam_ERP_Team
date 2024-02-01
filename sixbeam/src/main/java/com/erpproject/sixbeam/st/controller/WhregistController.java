package com.erpproject.sixbeam.st.controller;

import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.service.WhregistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping("/sixbeam/st/whregist")
@RequiredArgsConstructor
@Controller
public class WhregistController {
    private final WhregistService whregistService;

    @GetMapping("/")
    public String root() {
        return "redirect:/sixbeam/home";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<WhregistEntity> whregistEntityList = this.whregistService.getList();
        model.addAttribute("whregistEntityList",whregistEntityList);
        return "Contents/ST/Whregist_list";

    }
    @GetMapping(value = "/detail/{whregistCd}")
    public String detail(Model model, @PathVariable("whregistCd") String whregistCd) {
        WhregistEntity whregistEntity = this.whregistService.getWhregistEntity(whregistCd);
        model.addAttribute("whregistEntity", whregistEntity);
        return "Contents/ST/Whregist_detail";
    }



}
