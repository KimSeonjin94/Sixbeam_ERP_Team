package com.erpproject.sixbeam.pur.controller;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pur.dto.OrinPutDto;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.form.OrinPutForm;
import com.erpproject.sixbeam.pur.service.OrinPutService;
import com.erpproject.sixbeam.ss.dto.EstimateDto;
import com.erpproject.sixbeam.ss.form.EstimateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String OrinPutCreate(Model model) {
        OrinPutForm form = new OrinPutForm();
        List<AccountEntity> accountEntity = this.orinputService.getactList();
        List<EmpInfoEntity> empInfoEntity = this.orinputService.getemplist();
        List<ItemEntity> itemEntity = this.orinputService.getitemlist();
        form.getOrinputDtos().add(new OrinPutDto());
        form.getOrinputDtos().add(new OrinPutDto());
        model.addAttribute("getactlist",accountEntity);
        model.addAttribute("getemplist",empInfoEntity);
        model.addAttribute("getitemlist",itemEntity);
        model.addAttribute("orinputForm",form);
        return "contents/pur/orinput_form";
    }

    @PostMapping("/save")
    public String saveOrinPut(@ModelAttribute OrinPutForm form) {
        List<OrinPutDto> orinPutDtos= form.getOrinputDtos();
        this.orinputService.save(orinPutDtos);
        return "redirect:/pur/orinput/list"; // 저장 후 목록 페이지로 리다이렉트
    }

    private OrinPutEntity convertToEntity(OrinPutDto orinPutDto) {
        OrinPutEntity orinPutEntity = new OrinPutEntity();
        // DTO에서 엔티티로 필드 값을 복사
        orinPutEntity.setOrinputReqDt(orinPutDto.getOrinputReqDt());
        orinPutEntity.setOrinputOrDt(orinPutDto.getOrinputOrDt());
        orinPutEntity.setEmpInfoEntity(orinPutDto.getEmpInfoEntity());
        orinPutEntity.setItemEntity(orinPutDto.getItemEntity());
        orinPutEntity.setOrinputAmt(orinPutDto.getOrinputAmt());
        orinPutEntity.setOrinputUp(orinPutDto.getOrinputUp());
        orinPutEntity.setOrinputSp(orinPutDto.getOrinputSp());
        orinPutEntity.setOrinputVat(orinPutDto.getOrinputVat());
        orinPutEntity.setOrinputSum(orinPutDto.getOrinputSum());
        orinPutEntity.setAccountEntity(orinPutDto.getAccountEntity());
        orinPutEntity.setOrinputDlvyDt(orinPutDto.getOrinputDlvyDt());
        orinPutEntity.setOrinputEtc(orinPutDto.getOrinputEtc());
        return orinPutEntity;
    }

}
