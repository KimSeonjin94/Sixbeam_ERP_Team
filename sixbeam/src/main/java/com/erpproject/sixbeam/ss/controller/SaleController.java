package com.erpproject.sixbeam.ss.controller;

import com.erpproject.sixbeam.ss.dto.EstimateDto;
import com.erpproject.sixbeam.ss.dto.SaleDto;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.MemberEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.form.EstimateForm;
import com.erpproject.sixbeam.ss.form.SaleForm;
import com.erpproject.sixbeam.ss.service.EstimateService;
import com.erpproject.sixbeam.ss.service.MemberService;
import com.erpproject.sixbeam.ss.service.SaleService;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.service.WhregistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@RequestMapping("/ss/sale")
@Controller
@Slf4j
public class SaleController {
    @Autowired
    private SaleService saleService;
    @Autowired
    private EstimateService estimateService;
    @Autowired
    private WhregistService whregistService;
    @Autowired
    private MemberService memberService;


    @GetMapping("/list")
    public String list(Model model) {
        SaleForm saleForm= new SaleForm();
        List<SaleEntity> saleEntities = saleService.getList();
        List<EstimateEntity> estimateEntities = estimateService.getList();
        List<WhregistEntity> whregistEntities= whregistService.getList();
        model.addAttribute("estimateEntities", estimateEntities);
        model.addAttribute("saleEntities", saleEntities);
        model.addAttribute("saleForm", saleForm);
        model.addAttribute("getwhregistlist",whregistEntities);
        return "contents/ss/sale_list";
    }
    @GetMapping("/new")
    public String create(Model model) {
        SaleDto saleDto= new SaleDto();
        List<EstimateEntity> estimateEntities = estimateService.getList();
        List<WhregistEntity> whregistEntities= whregistService.getList();
        model.addAttribute("estimateEntities", estimateEntities);
        model.addAttribute("saleDto", saleDto);
        model.addAttribute("getwhregistlist",whregistEntities);
        return "contents/ss/sale_form";
    }
    @GetMapping(value = "/list/detail/{id}")
    public ResponseEntity<Map<String, Object>> detail(@PathVariable("id") String id) {
        Optional<SaleEntity> optionalSaleEntity = saleService.getId(id);

        if (optionalSaleEntity.isPresent()) {
            SaleEntity saleEntity = optionalSaleEntity.get();
            List<EstimateEntity> estimateEntities = estimateService.getIdList(saleEntity.getEstimateCd());

            Map<String, Object> response = new HashMap<>();
            response.put("saleEntity", saleEntity);
            response.put("estimateEntities", estimateEntities);
            if(estimateEntities.get(0).getAccountEntity().getAccountNm().equals("개인거래")) {
                MemberEntity memberEntity =memberService.getMemberList(estimateEntities.get(0).getEstimateCd()).get();
                response.put("memberEntity", memberEntity);
            }
            return ResponseEntity.ok(response);
        } else {
            // 존재하지 않는 경우 적절한 예외 처리나 오류 응답
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "SaleEntity not found for ID: " + id);
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }



    @PostMapping("/create")
    public ResponseEntity<?> createSale(@ModelAttribute SaleDto saleDto) {
        try {
            this.saleService.create(saleDto);
            return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/ss/sale/list"));
        }catch (Exception e){
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/ss/sale/new");
            return ResponseEntity.badRequest().body(errorResponse);

        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@ModelAttribute SaleDto saleDto) {
        try {
            saleService.update(saleDto);
            // 성공 응답
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("redirectUrl", "/ss/sale/list");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            // 실패 응답
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "업데이트에 실패하였습니다.");
            errorResponse.put("redirectUrl", "/ss/sale/list");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("selectedid") List<String> selectedid) {
        try {
            saleService.delete(selectedid);
            Map<String,Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("redirectUrl", "/ss/sale/list");
            response.put("message","삭제 되었습니다");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", e.getMessage());
            errorResponse.put("redirectUrl", "/ss/sale/list");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }


}
