package com.erpproject.sixbeam.pur.controller;

import com.erpproject.sixbeam.pur.dto.InputDto;
import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.service.InputService;
import com.erpproject.sixbeam.pur.service.OrinPutService;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.service.WhregistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
            return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/pur/input/list")); // 저장 후 목록 페이지로 리다이렉트
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/pur/input/create");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
