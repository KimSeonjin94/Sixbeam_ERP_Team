package com.erpproject.sixbeam.pur.controller;

import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.form.OrinPutForm;
import com.erpproject.sixbeam.pur.service.OrinPutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/pur")
@RequiredArgsConstructor
@Controller
public class OrinPutController {
    private final OrinPutService orinputService;

    @GetMapping("/OrinPutlist")
    public String OrinPutlist(Model model) {
        List<OrinPutEntity> orinputEntity = this.orinputService.getList();
        model.addAttribute("orinputEntity",orinputEntity);
        return "contents/Pur/OrinPut_list";
    }

    @GetMapping("/OrinPutcreate")
    public String OrinPutCreate(OrinPutForm orinPutForm) {
        return "contents/Pur/OrinPut_Form";
    }

}
