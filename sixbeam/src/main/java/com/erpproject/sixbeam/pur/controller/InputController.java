package com.erpproject.sixbeam.pur.controller;

import com.erpproject.sixbeam.pur.dto.InputDto;
import com.erpproject.sixbeam.pur.dto.OrinPutDto;
import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.form.InputForm;
import com.erpproject.sixbeam.pur.form.OrinPutForm;
import com.erpproject.sixbeam.pur.service.InputService;
import com.erpproject.sixbeam.pur.service.OrinPutService;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.service.WhregistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/pur/input")
@RequiredArgsConstructor
@Controller
public class InputController {
    private final InputService inputService;
    private final OrinPutService orinPutService;
    private final WhregistService whregistService;
    @GetMapping("/list")
    public String GetList(Model model) {
        List<InputEntity> inputEntity = this.inputService.getList();
        model.addAttribute("inputEntity",inputEntity);
        return "contents/pur/input_list";
    }

    @GetMapping("/create")
    public String OrinPutCreate(Model model) {
        InputDto inputDto=new InputDto();
        List<OrinPutEntity> orinPutEntity = orinPutService.getList();
        List<WhregistEntity> whregistEntity = whregistService.getList();
        model.addAttribute("orinputEntities",orinPutEntity);
        model.addAttribute("inputDto",inputDto);
        model.addAttribute("getwhregistlist",whregistEntity);

        return "contents/pur/input_form";
    }

    @PostMapping("/save")
    public String saveOrinPut(@ModelAttribute InputForm form) {
        List<InputDto> inPutDtos= form.getInputDtos();
        this.inputService.save(inPutDtos);
        return "redirect:/pur/orinput/list"; // 저장 후 목록 페이지로 리다이렉트
    }
}
