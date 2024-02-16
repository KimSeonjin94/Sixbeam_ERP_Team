package com.erpproject.sixbeam.pur.controller;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pur.dto.OrinPutDto;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.form.OrinPutForm;
import com.erpproject.sixbeam.pur.service.OrinPutService;
import com.erpproject.sixbeam.ss.dto.EstimateDto;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.form.EstimateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/pur/orinput")
@RequiredArgsConstructor
@Controller
public class OrinPutController {
    private final OrinPutService orinputService;

    @GetMapping("/list")
    public String OrinPutlist(Model model) {
        OrinPutForm form = new OrinPutForm();
        List<OrinPutEntity> orinputEntity = this.orinputService.getList();
        List<AccountEntity> accountEntity = this.orinputService.getactList();
        List<EmpInfoEntity> empInfoEntity = this.orinputService.getemplist();
        List<ItemEntity> itemEntity = this.orinputService.getitemlist();
        model.addAttribute("orinputEntity",orinputEntity);
        model.addAttribute("getactlist",accountEntity);
        model.addAttribute("getemplist",empInfoEntity);
        model.addAttribute("getitemlist",itemEntity);
        model.addAttribute("orinputForm",form);
        return "contents/pur/orinput_list";
    }

    @GetMapping(value = "/list/detail/{id}")
    public ResponseEntity<List<OrinPutEntity>> detail(@PathVariable("id") String id){
        List<OrinPutEntity> orinPutEntities = this.orinputService.getIdList(id);
        System.out.println(orinPutEntities.toString());
        return ResponseEntity.ok(orinPutEntities);
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

    @PostMapping("/update")
    public String updateOrinput(@ModelAttribute OrinPutForm form){
        List<OrinPutDto> orinPutDtos= form.getOrinputDtos();
        orinputService.updateAll(orinPutDtos);

        return "redirect:/pur/orinput/list";
    }

    @PostMapping("/delete")
    public String deleteOrinput(@RequestParam("selectedOrinput") List<String> selectedOrinputIds, Model model) {
        try {
            // 선택된 발주 정보를 삭제
            orinputService.delete(selectedOrinputIds);
            return "redirect:/pur/orinput/list"; // 삭제 후 목록 페이지로 리다이렉트
        } catch (IllegalStateException e) {
            // ORINPUT_CD를 참조하는 다른 엔티티가 있을 때 모달 창 표시
            model.addAttribute("deleteError", true);
            return "redirect:/pur/orinput/list";
        }
    }
}
