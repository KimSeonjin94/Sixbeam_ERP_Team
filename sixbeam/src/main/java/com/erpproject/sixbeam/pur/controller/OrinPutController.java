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
import org.springframework.validation.BindingResult;
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
        Map<String, Object> Response = null;
        try {
            List<OrinPutDto> orinPutDtos = form.getOrinputDtos();
            this.orinputService.save(orinPutDtos);
            Response = new HashMap<>();
            Response.put("status", "success");
            Response.put("message", "정상적으로 저장되었습니다.");
            Response.put("redirectUrl", "/pur/orinput/list");
            return ResponseEntity.ok().body(Response); // 저장 후 목록 페이지로 리다이렉트
        } catch (Exception e){
            Response = new HashMap<>();
            Response.put("status", "error");
            Response.put("message", String.format("저장에 실패 하였습니다.[%s]", e.getMessage()));
            Response.put("redirectUrl", "/pur/orinput/create");
            return ResponseEntity.badRequest().body(Response);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateOrinput(@ModelAttribute OrinPutForm form){
        Map<String, Object> Response = null;
        try {
            List<OrinPutDto> orinPutDtos = form.getOrinputDtos();
            orinputService.updateAll(orinPutDtos);
            Response = new HashMap<>();
            Response.put("status", "success");
            Response.put("message", "정상적으로 수정되었습니다.");
            Response.put("redirectUrl", "/pur/orinput/list");
            return ResponseEntity.ok().body(Response);
        } catch (Exception e){
            Response = new HashMap<>();
            Response.put("status", "error");
            Response.put("message", String.format("수정에 실패 하였습니다.[%s]", e.getMessage()));
            Response.put("redirectUrl", "/pur/orinput/list");
            return ResponseEntity.badRequest().body(Response);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteOrinput(@RequestParam("selectedOrinput") List<String> selectedOrinputIds, RedirectAttributes redirectAttributes) {
        Map<String, Object> Response = null;
        try {
            orinputService.delete(selectedOrinputIds);
            Response = new HashMap<>();
            Response.put("status", "success");
            Response.put("message", "정상적으로 삭제되었습니다.");
            Response.put("redirectUrl", "/pur/orinput/list");
            return ResponseEntity.ok().body(Response); // 삭제 후 목록 페이지로 리다이렉트
        } catch (IllegalStateException e) {
            Response = new HashMap<>();
            Response.put("status", "error");
            Response.put("message", String.format("삭제에 실패 하였습니다.[%s]", e.getMessage()));
            Response.put("redirectUrl", "/pur/orinput/list");
            return ResponseEntity.badRequest().body(Response);
        }
    }
}
