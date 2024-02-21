package com.erpproject.sixbeam.pur.controller;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pur.dto.OrinPutDto;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.form.OrinPutForm;
import com.erpproject.sixbeam.pur.service.OrinPutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
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
    public ResponseEntity<?> saveOrinPut(@ModelAttribute OrinPutForm form) {
        try {
            List<OrinPutDto> orinPutDtos = form.getOrinputDtos();
            this.orinputService.save(orinPutDtos);
            return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl","/pur/orinput/list")); // 저장 후 목록 페이지로 리다이렉트
        } catch (Exception e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/pur/orinput/create");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateOrinput(@ModelAttribute OrinPutForm form){
        try {
            List<OrinPutDto> orinPutDtos = form.getOrinputDtos();
            orinputService.updateAll(orinPutDtos);

            return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl","/pur/orinput/list"));
        } catch (Exception e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "수정에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/pur/orinput/update");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteOrinput(@RequestParam("selectedOrinput") List<String> selectedOrinputIds, RedirectAttributes redirectAttributes) {
        try {
            // 선택된 발주 정보를 삭제
            orinputService.delete(selectedOrinputIds);
            return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl","/pur/orinput/list")); // 삭제 후 목록 페이지로 리다이렉트
        } catch (IllegalStateException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", e.getMessage());
            errorResponse.put("redirectUrl", "/pur/orinput/list");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
