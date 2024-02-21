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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping(value = "/list/detail/{id}")
    public ResponseEntity<List<InputEntity>> detail(@PathVariable("id") String id){
        List<InputEntity> inPutEntities = this.inputService.getIdList(id);
        System.out.println(inPutEntities.toString());
        return ResponseEntity.ok(inPutEntities);
    }

    @GetMapping("/create")
    public String InPutCreate(Model model) {
        InputDto inputDto = new InputDto();
        List<OrinPutEntity> orinPutEntity = orinPutService.getList();
        List<WhregistEntity> whregistEntity = whregistService.getList();
        model.addAttribute("orinputEntities",orinPutEntity);
        model.addAttribute("getwhregistlist",whregistEntity);
        model.addAttribute("InputDto",inputDto);
        return "contents/pur/input_form";
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveInPut(@ModelAttribute InputDto inputDto) {
        try {
            this.inputService.save(inputDto);
            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("status", "success");
            successResponse.put("message", "정상적으로 저장되었습니다.");
            successResponse.put("redirectUrl", "/pur/input/list");
            return ResponseEntity.ok().body(successResponse); // 저장 후 목록 페이지로 리다이렉트
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/pur/input/create");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateinput(@ModelAttribute InputDto inputDto){
        try {
            inputService.update(inputDto);
            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("status", "success");
            successResponse.put("message", "정상적으로 수정되었습니다.");
            successResponse.put("redirectUrl", "/pur/input/list");
            return ResponseEntity.ok().body(successResponse);
        } catch (Exception e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "수정에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/pur/input/update");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteinput(@RequestParam("selectedinput") List<String> selectedInputIds, RedirectAttributes redirectAttributes) {
        try {
            // 선택된 발주 정보를 삭제
            inputService.delete(selectedInputIds);
            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("status", "success");
            successResponse.put("message", "정상적으로 삭제되었습니다.");
            successResponse.put("redirectUrl", "/pur/input/list");
            return ResponseEntity.ok().body(successResponse); // 삭제 후 목록 페이지로 리다이렉트
        } catch (IllegalStateException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", e.getMessage());
            errorResponse.put("redirectUrl", "/pur/input/list");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
