package com.erpproject.sixbeam.st.controller;

import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import com.erpproject.sixbeam.st.service.ReleaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/st/release")
public class ReleaseController {

    private final ReleaseService releaseService;
    @GetMapping("/")
    public String root() {
        return "redirect:/sixbeam/home";
    }
    @GetMapping("/list")
    public String list(Model model) {
        List<ReleaseEntity> releaseEntityList = this.releaseService.getList();
        model.addAttribute("releaseEntityList",releaseEntityList);
        return "contents/st/release_list";
    }
    @GetMapping(value = "/detail/{releaseCd}")
    public String detail(Model model, @PathVariable("releaseCd") String releaseCd) {
        ReleaseEntity releaseEntity = this.releaseService.getReleaseEntity(releaseCd);
        model.addAttribute("releaseEntity",releaseEntity);
        return "contents/st/release_detail";
    }

}
