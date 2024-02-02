package com.erpproject.sixbeam.pur.controller;

import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.pur.service.InputService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/pur")
@RequiredArgsConstructor
@Controller
public class InputController {
    private final InputService inputService;

    @GetMapping("/Inputlist")
    public String GetList(Model model) {
        List<InputEntity> inputEntity = this.inputService.getList();
        model.addAttribute("inputEntity",inputEntity);
        return "Contents/Pur/Input_list";
    }
}
