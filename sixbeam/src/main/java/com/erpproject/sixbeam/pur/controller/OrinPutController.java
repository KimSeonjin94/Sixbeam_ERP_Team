package com.erpproject.sixbeam.pur.controller;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.form.OrinPutForm;
import com.erpproject.sixbeam.pur.service.OrinPutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/pur/orinput")
@RequiredArgsConstructor
@Controller
public class OrinPutController {
    private final OrinPutService orinputService;

    @GetMapping("/list")
    public String OrinPutlist(Model model) {
        List<OrinPutEntity> orinputEntity = this.orinputService.getList();
        model.addAttribute("orinputEntity",orinputEntity);
        return "contents/pur/orinput_list";
    }

    @GetMapping("/create")
    public String OrinPutCreate(OrinPutForm orinPutForm, Model model) {
        List<AccountEntity> accountEntity = this.orinputService.getactList();
        List<EmpInfoEntity> empInfoEntity = this.orinputService.getemplist();
        model.addAttribute("getactlist",accountEntity);
        model.addAttribute("getemplist",empInfoEntity);
        return "contents/pur/orinput_form";
    }

}
