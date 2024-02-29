package com.erpproject.sixbeam.st.controller;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.service.ItemService;
import com.erpproject.sixbeam.ss.dto.SaleAndEstimateDto;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.service.SaleService;
import com.erpproject.sixbeam.st.dto.AsDto;
import com.erpproject.sixbeam.st.dto.ReleaseDto;
import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.form.AsForm;
import com.erpproject.sixbeam.st.form.ReleaseForm;
import com.erpproject.sixbeam.st.service.ReleaseService;
import com.erpproject.sixbeam.st.service.WhregistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private final AccountService accountService;
    private final WhregistService whregistService;
    private final ItemService itemService;
    private final SaleService saleService;

    @GetMapping("/")
    public String root() {
        return "redirect:/sixbeam/home";
    }
    @GetMapping("/list")
    public String list(Model model) {
        List<ReleaseEntity> releaseEntityList = this.releaseService.getList();
        model.addAttribute("releaseEntityList",releaseEntityList);
        return "contents/st/release_list";
    }
    @GetMapping(value = "/detail/{releaseCd}")
    public String detail(Model model, @PathVariable("releaseCd") String releaseCd) {
        ReleaseEntity releaseEntity = this.releaseService.getReleaseEntity(releaseCd);
        model.addAttribute("releaseEntity",releaseEntity);
        return "contents/st/release_detail";
    }
    //출하등록_페이지
    @GetMapping("/create")
    public String releaseCreate(Model model){
        ReleaseForm form = new ReleaseForm();
        List<AccountEntity> accountEntity = this.accountService.getList();
        List<EmpInfoEntity> empInfoEntity = this.empInfoService.getList();
        List<WhregistEntity> whregistEntitiy = this.whregistService.getList();
        List<ItemEntity> itemEntity = this.itemService.getList();
        List<SaleAndEstimateDto> saleAndEstimateDtos = this.saleService.getRelease("판매대기중");


        form.getReleaseDtos().add(new ReleaseDto());
        form.getReleaseDtos().add(new ReleaseDto());
        model.addAttribute("getactlist",accountEntity);
        model.addAttribute("getemplist",empInfoEntity);
        model.addAttribute("getitemlist",itemEntity);
        model.addAttribute("getwhregistlist",whregistEntitiy);
        model.addAttribute("getsalelist",saleAndEstimateDtos);
        model.addAttribute("releaseForm",form);
        return "contents/st/release_form";
    }
    @PostMapping("/save")
    public ResponseEntity<?> releaseCreateDto(@ModelAttribute ReleaseForm form){
        List<ReleaseDto> releaseDtos= form.getReleaseDtos();
        try {
            this.releaseService.create(releaseDtos);
            return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/st/release/list"));
        }catch (Exception e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/st/release/create");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
