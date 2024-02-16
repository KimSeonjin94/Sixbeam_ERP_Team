package com.erpproject.sixbeam.st.controller;

import com.erpproject.sixbeam.st.dto.WhregistDto;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.form.WhregistForm;
import com.erpproject.sixbeam.st.service.WhregistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
@RequestMapping("/st/whregist")
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
        return "contents/st/whregist_list";

    }
    @GetMapping(value = "/detail/{whregistCd}")
    public String detail(Model model, @PathVariable("whregistCd") String whregistCd) {
        WhregistEntity whregistEntity = this.whregistService.getWhregistEntity(whregistCd);
        model.addAttribute("whregistEntity", whregistEntity);
        return "contents/st/whregist_detail";
    }
    //창고등록 페이지상에서 창고 등록
    @GetMapping("/create")
    public String whregistCreate() {
        return "contents/st/whregist_form";
    }
    @PostMapping("/create")
    public String whregistCreate(@RequestParam(value="whregistCd") String whregistCd,@RequestParam(value="whregistNm") String whregistNm ) {
       this.whregistService.pageCreate(whregistCd,whregistNm);
        return "redirect:/st/whregist/list";
    }
    //창고현황-신규 모달에서 창고 등록
    @PostMapping("/modalcreate")
    public String modalCreate(@ModelAttribute WhregistDto whregistDto) {
        whregistService.modalCreate(whregistDto);
        return "redirect:list";
    }
    ///



}
