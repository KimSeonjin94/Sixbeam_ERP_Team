package com.erpproject.sixbeam.ss.controller;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.service.AccountService;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import com.erpproject.sixbeam.pd.dto.ItemDto;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.service.ItemService;
import com.erpproject.sixbeam.ss.dto.EstimateDto;
import com.erpproject.sixbeam.ss.dto.EstimateForm;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.service.EstimateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/ss/estimate")
@Controller
public class EstimateController {
    @Autowired
    private EstimateService estimateService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private EmpInfoService empInfoService;
    @Autowired
    private ItemService itemService;
    @GetMapping("/new")
    public String newEstimateDto(Model model) {
        EstimateForm form=new EstimateForm();
        List<AccountEntity> accountEntity = this.accountService.getList();
        List<EmpInfoEntity> empInfoEntity = this.empInfoService.getList();
        List<ItemEntity> itemEntity = this.itemService.list();
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
        this.estimateService.create(estimateDtos);
        return "redirect:contents/ss/estimate_list";
    }
    @GetMapping("/list")
    public String list(Model model){
        List< EstimateEntity> estimateEntities = estimateService.getList();
        model.addAttribute("estimateEntities",estimateEntities);
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
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Integer.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                try {
                    String value = text.replace("₩", "").replace(",", "");
                    setValue(Integer.parseInt(value));
                } catch (NumberFormatException e) {
                    setValue(0); // 또는 유효하지 않은 값 처리
                }
            }
        });
    }
}