package com.erpproject.sixbeam.st.controller;

import com.erpproject.sixbeam.st.dto.WhregistDto;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.form.AsForm;
import com.erpproject.sixbeam.st.form.WhregistForm;
import com.erpproject.sixbeam.st.service.WhregistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/st/whregist")
@RequiredArgsConstructor
@Controller
public class WhregistController {
    private final WhregistService whregistService;

    @GetMapping("/")
    public String root() {
        return "redirect:/sixbeam/home";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<WhregistEntity> whregistEntityList = this.whregistService.getList();
        model.addAttribute("whregistEntityList",whregistEntityList);
        return "contents/st/whregist_list";
    }
    @GetMapping(value = "/list/detail/{id}")
    public ResponseEntity<List<WhregistEntity>> detail(@PathVariable("id") String id) {
        List<WhregistEntity> whregistEntities = whregistService.getIdList(id);
        System.out.println(whregistEntities.toString());
        return ResponseEntity.ok(whregistEntities);
    }
    //창고등록 페이지상에서 창고 등록
    @GetMapping("/create")
    public String Create(Model model){
        WhregistForm form = new WhregistForm();
        form.getWhregistDtos().add(new WhregistDto());
        form.getWhregistDtos().add(new WhregistDto());
        model.addAttribute("whregistForm",form);
        return "contents/st/whregist_form";
    }


    @PostMapping("/save")
    public ResponseEntity<?> whregistCreateDto(@ModelAttribute WhregistForm whregistForm){
        List<WhregistDto> whregistDtos = whregistForm.getWhregistDtos();
        try {
            this.whregistService.create(whregistDtos);
            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("status", "success");
            successResponse.put("message", "정상적으로 저장되었습니다.");
            successResponse.put("redirectUrl", "/st/whregist/list");
            return ResponseEntity.ok().body(successResponse);
        }catch (Exception e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/st/whregist/create");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(@ModelAttribute WhregistDto whregistDto) {
        try{//성공응답
            whregistService.updateAll(whregistDto);
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "정상적으로 수정되었습니다.");
            response.put("redirectUrl", "/st/whregist/list");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) { //실패 응답
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "수정에 실패하였습니다.");
            errorResponse.put("redirectUrl", "/st/whregist/list");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("selectedwhregist") List<String> selectedid, RedirectAttributes redirectAttributes) {
        try {
            whregistService.delete(selectedid);
            Map<String,Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "삭제에 성공하였습니다.");
            response.put("redirectUrl", "/st/whregist/list");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "삭제에 실패하였습니다.");
            errorResponse.put("redirectUrl", "/st/whregist/list");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
