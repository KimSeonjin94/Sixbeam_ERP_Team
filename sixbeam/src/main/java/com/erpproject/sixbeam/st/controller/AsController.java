package com.erpproject.sixbeam.st.controller;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.service.ItemService;
import com.erpproject.sixbeam.st.dto.AsDto;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.form.AsForm;
import com.erpproject.sixbeam.st.service.AsService;
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

@RequiredArgsConstructor
@Controller
@RequestMapping("/st/as")
public class AsController {

    private final AsService asService;
    private final AccountService accountService;
    private final EmpInfoService empInfoService;
    private final WhregistService whregistService;
    private final ItemService itemService;

    @GetMapping("/")
    public String root() {
        return "redirect:/sixbeam/home";
    }
    @GetMapping("/list")
    public String list(Model model) {
        AsForm form = new AsForm();
        List<AsEntity> asEntity = this.asService.getList();
        List<AccountEntity> accountEntity = this.accountService.getList();
        List<EmpInfoEntity> empInfoEntity = this.empInfoService.getList();
        List<ItemEntity> itemEntitiy = this.itemService.getList();
        List<WhregistEntity> whregistEntity = this.whregistService.getList();
        model.addAttribute("getactlist",accountEntity);
        model.addAttribute("getemplist",empInfoEntity);
        model.addAttribute("getitemlist",itemEntitiy);
        model.addAttribute("getwhregistlist", whregistEntity);
        model.addAttribute("asForm",form);
        model.addAttribute("asEntityList",asEntity);
        return "contents/st/as_list";
    }
    @GetMapping(value = "/list/detail/{asCd}")
    public ResponseEntity<List<AsEntity>> detail(@PathVariable("asCd") String asCd) {
        List<AsEntity> asEntities = asService.getIdList(asCd);
        System.out.println(asEntities.toString());
        return ResponseEntity.ok(asEntities);
    }
    //AS등록_페이지
    @GetMapping("/create")
    public String asCreate(Model model){
        AsForm form = new AsForm();
        List<AccountEntity> accountEntity = this.accountService.getList();
        List<EmpInfoEntity> empInfoEntity = this.empInfoService.getList();
        List<ItemEntity> itemEntitiy = this.itemService.getList();
        List<WhregistEntity> whregistEntity = this.whregistService.getList();
        form.getAsDtos().add(new AsDto());
        form.getAsDtos().add(new AsDto());
        model.addAttribute("getactlist",accountEntity);
        model.addAttribute("getemplist",empInfoEntity);
        model.addAttribute("getitemlist",itemEntitiy);
        model.addAttribute("getwhregistlist", whregistEntity);
        model.addAttribute("asForm",form);
        return "contents/st/as_form";
    }
    @PostMapping("/save")
    public ResponseEntity<?> asCreateDto(@ModelAttribute AsForm asForm){
        List<AsDto> asDtos = asForm.getAsDtos();
        try {
            this.asService.create(asDtos);
            Map<String, Object> successResponse = new HashMap<>();
            successResponse.put("status", "success");
            successResponse.put("message", "정상적으로 저장되었습니다.");
            return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/st/as/list"));
        }catch (Exception e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/st/as/create");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    @PostMapping("/update")
    public ResponseEntity<?> update(@ModelAttribute AsDto asDto) {
        try{//성공응답
            asService.updateAll(asDto);
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "정상적으로 수정되었습니다.");
            response.put("redirectUrl", "/st/as/list");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) { //실패 응답
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "수정에 실패하였습니다.");
            errorResponse.put("redirectUrl", "/st/as/list");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("selectedas") List<String> selectedid, RedirectAttributes redirectAttributes) {
        try {
            asService.delete(selectedid);
            Map<String,Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "삭제에 성공하였습니다.");
            response.put("redirectUrl", "/st/as/list");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "삭제에 실패하였습니다.");
            errorResponse.put("redirectUrl", "/st/as/list");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
