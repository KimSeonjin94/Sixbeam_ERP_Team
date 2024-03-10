package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.PurDto;
import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.entity.PurEntity;
import com.erpproject.sixbeam.ac.repository.PurRepository;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.ac.service.PurService;
import com.erpproject.sixbeam.pur.entity.InputEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/ac")
public class PurController {

    private final AccountService accountService;
    @Autowired
    private PurService purService;

    @GetMapping("/pur/purSlip")
    public String purSlipForm(Model model) {
        List<AccountEntity> actEntity = this.accountService.getList();
        List<InputEntity> inputEntities = this.purService.getInputList();
        model.addAttribute("actList", actEntity);
        model.addAttribute("inputEntities",inputEntities);
        return "contents/ac/pur_slip";
    }


}
