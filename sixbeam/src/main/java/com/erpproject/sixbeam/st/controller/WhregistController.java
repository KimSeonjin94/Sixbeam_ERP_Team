package com.erpproject.sixbeam.st.controller;

import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.st.dto.WhregistDto;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.form.WhregistForm;
import com.erpproject.sixbeam.st.service.WhregistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    @GetMapping(value = "/list/detail/{id}")
    public ResponseEntity<List<WhregistEntity>> detail(@PathVariable("id") String id) {
        List<WhregistEntity> whregistEntities = this.whregistService.getIdList(id);
        System.out.println(whregistEntities.toString());
        return ResponseEntity.ok(whregistEntities);
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
    public String modalCreate(@ModelAttribute WhregistForm form) {
        List<WhregistDto> whregistDtos = form.getWhregistDtos();
        whregistService.modalCreate(whregistDtos);
        return "redirect:/st/whregist/list";
    }
}
