package com.erpproject.sixbeam.st.controller;

import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.repository.AsRepository;
import com.erpproject.sixbeam.st.service.AsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/st/as")
public class AsController {

    private final AsService asService;

    @GetMapping("/")
    public String root() {
        return "redirect:/sixbeam/home";
    }
    @GetMapping("/list")
    public String list(Model model) {
        List<AsEntity> asEntityList = this.asService.getList();
        model.addAttribute("asEntityList",asEntityList);
        return "contents/st/as_list";
    }
    @GetMapping(value = "/detail/{asCd}")
    public String detail(Model model, @PathVariable("asCd") String asCd) {
        AsEntity asEntity = this.asService.getAsEntity(asCd);
        model.addAttribute("asEntity",asEntity);
        return "contents/st/as_detail";
    }


}
