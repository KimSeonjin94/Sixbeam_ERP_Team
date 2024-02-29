package com.erpproject.sixbeam.st.controller;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.service.SaleService;
import com.erpproject.sixbeam.st.dto.ReleaseDto;
import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import com.erpproject.sixbeam.st.form.ReleaseForm;
import com.erpproject.sixbeam.st.service.ReleaseService;
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

@RequiredArgsConstructor
@Controller
@RequestMapping("/st/release")
public class ReleaseController {

    private final ReleaseService releaseService;
    private final EmpInfoService empInfoService;
    private final SaleService saleService;

    @GetMapping("/")
    public String root() {
        return "redirect:/sixbeam/home";
    }
    @GetMapping("/list")
    public String list(Model model) {
        ReleaseForm releaseForm = new ReleaseForm();
        List<ReleaseEntity> releaseEntity = this.releaseService.getList();
        List<EmpInfoEntity> empInfoEntity = this.empInfoService.getList();
        List<SaleEntity> saleEntity = this.saleService.getList();
        model.addAttribute("releaseEntityList",releaseEntity);
        model.addAttribute("getemplist",empInfoEntity);
        model.addAttribute("getsalelist",saleEntity);
        model.addAttribute("releaseForm",releaseForm);
        return "contents/st/release_list";
    }
    @GetMapping(value = "/list/detail/{releaseCd}")
    public ResponseEntity<List<ReleaseEntity>> detail(@PathVariable("releaseCd") String releaseCd) {
        List<ReleaseEntity> releaseEntities = releaseService.getIdList(releaseCd);
        System.out.println(releaseEntities.toString());
        return ResponseEntity.ok(releaseEntities);
    }
    //출하등록_페이지
    @GetMapping("/create")
    public String releaseCreate(Model model){
        ReleaseForm form = new ReleaseForm();
        List<EmpInfoEntity> empInfoEntity = this.empInfoService.getList();
        List<SaleEntity> saleEntity = this.saleService.getList();
        form.getReleaseDtos().add(new ReleaseDto());
        form.getReleaseDtos().add(new ReleaseDto());
        model.addAttribute("getemplist",empInfoEntity);
        model.addAttribute("getsalelist",saleEntity);
        model.addAttribute("releaseForm",form);
        return "contents/st/release_form";
    }
    @PostMapping("/save")
    public ResponseEntity<?> releaseCreateDto(@ModelAttribute ReleaseForm form){
        List<ReleaseDto> releaseDtos= form.getReleaseDtos();
        try {
            this.releaseService.create(releaseDtos);
            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("status", "success");
            successResponse.put("message", "정상적으로 저장되었습니다.");
            return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/st/release/list"));
        }catch (Exception e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/st/release/create");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(@ModelAttribute ReleaseDto releaseDto) {
        try{//성공응답
            releaseService.updateAll(releaseDto);
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "정상적으로 수정되었습니다.");
            response.put("redirectUrl", "/st/release/list");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) { //실패 응답
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "수정에 실패하였습니다.");
            errorResponse.put("redirectUrl", "/st/release/list");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("selectedrel") List<String> selectedid, RedirectAttributes redirectAttributes){
        try{
            releaseService.delete(selectedid);
            Map<String,Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "삭제에 성공하였습니다.");
            response.put("redirectUrl", "/st/release/list");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "삭제에 실패하였습니다.");
            errorResponse.put("redirectUrl", "/st/release/list");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
