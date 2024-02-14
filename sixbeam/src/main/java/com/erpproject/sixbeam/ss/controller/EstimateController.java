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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.Optional;

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
    public  String createEstimateDto(@ModelAttribute EstimateForm form){
        List<EstimateDto> estimateDtos= form.getEstimateDtos();
        for(int i=0; i<estimateDtos.size(); i++){

            logger.info("Submitted form data: {}", estimateDtos);
        }
        this.estimateService.create(estimateDtos);
        return "redirect:ss/estimate/list";
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
    public String detail(Model model, @PathVariable("id") String id){
        List<EstimateEntity> estimateEntities = estimateService.getIdList(id);
        return "";
    }

    @GetMapping("/getitemdata")
    public Optional<ItemEntity> itemlist(Model model, @RequestParam String itemCd){

        return estimateService.getItemCd(itemCd);
    }

}