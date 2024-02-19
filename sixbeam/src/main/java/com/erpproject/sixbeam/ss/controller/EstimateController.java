package com.erpproject.sixbeam.ss.controller;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.service.ItemService;
import com.erpproject.sixbeam.ss.dto.EstimateDto;
import com.erpproject.sixbeam.ss.form.EstimateForm;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.service.EstimateService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.util.*;

@RequestMapping("/ss/estimate")
@Controller
@Slf4j
public class EstimateController {
    @Autowired
    private EstimateService estimateService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private EmpInfoService empInfoService;
    @Autowired
    private ItemService itemService;

    private static final Logger logger = LoggerFactory.getLogger(EstimateController.class);
    @GetMapping("/new")
    public String newEstimateDto(Model model) {
        EstimateForm form=new EstimateForm();
        List<AccountEntity> accountEntity = this.accountService.getList();
        List<EmpInfoEntity> empInfoEntity = this.empInfoService.getList();
        List<ItemEntity> itemEntity = this.itemService.getList();
        form.getEstimateDtos().add(new EstimateDto());
        form.getEstimateDtos().add(new EstimateDto());
        model.addAttribute("getactlist",accountEntity);
        model.addAttribute("getemplist",empInfoEntity);
        model.addAttribute("getitemlist",itemEntity);
        model.addAttribute("estimateForm",form);
        return "contents/ss/estimate_form";
    }
    @PostMapping("/create")
    public  ResponseEntity<?> createEstimateDto(@ModelAttribute EstimateForm form){
        List<EstimateDto> estimateDtos= form.getEstimateDtos();
        try {
            this.estimateService.create(estimateDtos);
            return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/ss/estimate/list"));
        }catch (Exception e){
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/ss/estimate/new");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    @GetMapping("/list")
    public String list(Model model){
        EstimateForm form=new EstimateForm();
        List< EstimateEntity> estimateEntities = estimateService.getList();
        List<AccountEntity> accountEntity = this.accountService.getList();
        List<EmpInfoEntity> empInfoEntity = this.empInfoService.getList();
        List<ItemEntity> itemEntity = this.itemService.getList();
        form.getEstimateDtos().add(new EstimateDto());
        form.getEstimateDtos().add(new EstimateDto());
        model.addAttribute("getactlist",accountEntity);
        model.addAttribute("getemplist",empInfoEntity);
        model.addAttribute("getitemlist",itemEntity);
        model.addAttribute("estimateEntities",estimateEntities);
        model.addAttribute("estimateForm",form);
        return "contents/ss/estimate_list";
    }
    @GetMapping(value = "/list/detail/{id}")
    public ResponseEntity<List<EstimateEntity>> detail(@PathVariable("id") String id){
        List<EstimateEntity> estimateEntities = estimateService.getIdList(id);
        System.out.println(estimateEntities.toString());
        return ResponseEntity.ok(estimateEntities);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateEstimate(@ModelAttribute EstimateForm form){
        List<EstimateDto> estimateDtos= form.getEstimateDtos();
        try {
            estimateService.updateAll(estimateDtos);
            // 성공 응답
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("redirectUrl", "/ss/estimate/list");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            // 실패 응답
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "업데이트에 실패하였습니다.");
            errorResponse.put("redirectUrl", "/ss/estimate/list");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    @GetMapping("/getitemdata")
    public Optional<ItemEntity> itemlist(Model model, @RequestParam String itemCd){

        return estimateService.getItemCd(itemCd);
    }

}