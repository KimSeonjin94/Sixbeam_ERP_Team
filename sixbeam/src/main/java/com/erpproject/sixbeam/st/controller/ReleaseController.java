package com.erpproject.sixbeam.st.controller;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.service.ItemService;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.repository.SaleRepository;
import com.erpproject.sixbeam.ss.service.EstimateService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.erpproject.sixbeam.ss.dto.SaleAndEstimateDto;

import java.util.*;

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
    private final SaleRepository saleRepository;
    private final EstimateService estimateService;

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
        List<SaleAndEstimateDto> saleAndEstimateDtos = this.saleService.getRelease("판매대기중");
        model.addAttribute("releaseEntityList",releaseEntity);
        model.addAttribute("getemplist",empInfoEntity);
        model.addAttribute("getsaleAndEstimatelist",saleAndEstimateDtos);
        model.addAttribute("getsalelist",saleEntity);
        model.addAttribute("releaseForm",releaseForm);
        return "contents/st/release_list";
    }
    @GetMapping(value = "/list/detail/{releaseCd}")
    public ResponseEntity<?> detail(@PathVariable("releaseCd") String releaseCd) {
        List<ReleaseEntity> releaseEntities = releaseService.getIdList(releaseCd);
        System.out.println(releaseEntities.toString());
        Map<String,Object> map = new HashMap<>();
        map.put("releaseEntities", releaseEntities);
        List<SaleAndEstimateDto> saleAndEstimateDtos = new ArrayList<>();
        for(ReleaseEntity releaseEntity : releaseEntities) {
            Optional<SaleEntity> saleEntity= saleRepository.findById(releaseEntity.getSaleEntity().getSaleCd());
            if(saleEntity.isEmpty()){
                break;
            }
            SaleAndEstimateDto saleAndEstimateDto = new SaleAndEstimateDto();
            saleAndEstimateDto.setSaleEntity(saleEntity.get());
            saleAndEstimateDto.setEstimateEntity(estimateService.getIdList(saleEntity.get().getEstimateCd()));
            saleAndEstimateDtos.add(saleAndEstimateDto);
        }
        map.put("saleAndEstimateDtos",saleAndEstimateDtos);
        return ResponseEntity.ok(map);
    }
    //출하등록_페이지
    @GetMapping("/create")
    public String releaseCreate(Model model){
        ReleaseDto releaseDto = new ReleaseDto();
        List<AccountEntity> accountEntity = this.accountService.getList();
        List<EmpInfoEntity> empInfoEntity = this.empInfoService.getList();
        List<WhregistEntity> whregistEntitiy = this.whregistService.getList();
        List<ItemEntity> itemEntity = this.itemService.getList();
        List<SaleAndEstimateDto> saleAndEstimateDtos = this.saleService.getRelease("판매대기중");
        model.addAttribute("getactlist",accountEntity);
        model.addAttribute("getemplist",empInfoEntity);
        model.addAttribute("getitemlist",itemEntity);
        model.addAttribute("getwhregistlist",whregistEntitiy);
        model.addAttribute("getsalelist",saleAndEstimateDtos);
        model.addAttribute("releaseForm",releaseDto);
        return "contents/st/release_form";
    }
    @PostMapping("/save")
    public ResponseEntity<?> releaseCreateDto(@ModelAttribute ReleaseDto releaseDto){
        try {
            this.releaseService.create(releaseDto);
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
    public ResponseEntity<?> delete(@RequestParam("selectedrelease") List<String> selectedid, RedirectAttributes redirectAttributes){
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
