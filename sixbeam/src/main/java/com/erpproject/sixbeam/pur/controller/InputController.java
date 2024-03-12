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
        List<OrinPutEntity> orinPutEntity = orinPutService.getList();
        List<WhregistEntity> whregistEntity = whregistService.getList();
        model.addAttribute("inputEntity",inputEntity);
        model.addAttribute("orinputEntities",orinPutEntity);
        model.addAttribute("getwhregistlist",whregistEntity);
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
        List<OrinPutEntity> orinPutEntity = orinPutService.getListInputComplete();
        List<WhregistEntity> whregistEntity = whregistService.getList();
        model.addAttribute("orinputEntities",orinPutEntity);
        model.addAttribute("getwhregistlist",whregistEntity);
        model.addAttribute("InputDto",inputDto);
        return "contents/pur/input_form";
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveInPut(@ModelAttribute InputDto inputDto) {
        Map<String, Object> Response = null;
        try {
            this.inputService.save(inputDto);
            Response = new HashMap<>();
            Response.put("status", "success");
            Response.put("message", "정상적으로 저장되었습니다.");
            Response.put("redirectUrl", "/pur/input/list");  // 저장 후 목록 페이지로 리다이렉트
            return ResponseEntity.ok().body(Response);
        } catch (Exception e) {
            Response = new HashMap<>();
            Response.put("status", "error");
            Response.put("message", String.format("저장에 실패 하였습니다.[%s]", e.getMessage()));
            if(inputDto.getEtc().contains("조회")){
                Response.put("redirectUrl", "/pur/input/list");
            }else {
                Response.put("redirectUrl", "/pur/input/create");
            }
            return ResponseEntity.badRequest().body(Response);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateinput(@ModelAttribute InputDto inputDto){
        Map<String, Object> Response = null;
        try {
            inputService.update(inputDto);
            Response = new HashMap<>();
            Response.put("status", "success");
            Response.put("message", "정상적으로 수정되었습니다.");
            Response.put("redirectUrl", "/pur/input/list");
            return ResponseEntity.ok().body(Response);
        } catch (Exception e){
            Response = new HashMap<>();
            Response.put("status", "error");
            Response.put("message", String.format("수정에 실패 하였습니다.[%s]", e.getMessage()));
            Response.put("redirectUrl", "/pur/input/list");
            return ResponseEntity.badRequest().body(Response);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteinput(@RequestParam("selectedinput") List<String> selectedInputIds, RedirectAttributes redirectAttributes) {
        Map<String, Object> Response = null;
        try {
            // 선택된 발주 정보를 삭제
            inputService.delete(selectedInputIds);
            Response = new HashMap<>();
            Response.put("status", "success");
            Response.put("message", "정상적으로 삭제되었습니다.");
            Response.put("redirectUrl", "/pur/input/list");
            return ResponseEntity.ok().body(Response); // 삭제 후 목록 페이지로 리다이렉트
        } catch (Exception e) {
            Response = new HashMap<>();
            Response.put("status", "error");
            Response.put("message", String.format("삭제에 실패 하였습니다.[%s]", e.getMessage()));
            Response.put("redirectUrl", "/pur/input/list");
            return ResponseEntity.badRequest().body(Response);
        }
    }
}
