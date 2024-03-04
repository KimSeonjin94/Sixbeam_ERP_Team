package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.Form.OrderForm;
import com.erpproject.sixbeam.pd.dto.InoutDto;
import com.erpproject.sixbeam.pd.dto.OrderDto;
import com.erpproject.sixbeam.pd.entity.InoutEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.OrderEntity;
import com.erpproject.sixbeam.pd.repository.InoutRepository;
import com.erpproject.sixbeam.pd.service.InoutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/pd/inout")
@RequiredArgsConstructor
@Controller
public class InoutController {

    private final InoutService inoutService;

    @GetMapping("/inoutlist")
    public String list(Model model) {

        // 서비스를 통해 모든 품목을 가져옴
        List<InoutEntity> inoutEntities = inoutService.getList();

        // 가져온 품목 리스트를 모델에 담음
        model.addAttribute("inoutEntities", inoutEntities);

        // 완품 리스트 뷰페이지 반환
        return "contents/pd/inout_list";
    }

    /*@GetMapping("/create")
    public String inoutCreate(Model model) {

        InoutForm form = new OrderForm();
        List<EmpInfoEntity> empInfoEntity = inoutService.getEmpList();
        List<ItemEntity> itemEntity =  inoutService.getItemList();

        form.getInoutDtos().add(new OrderDto());
        form.getInoutDtos().add(new OrderDto());

        model.addAttribute("getEmpList",empInfoEntity);
        model.addAttribute("getItemList",itemEntity);
        model.addAttribute("orderForm",form);

        return "contents/pd/order_form";
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveorder(@ModelAttribute InoutForm inoutForm) {

        try {

            List<InoutDto> inoutDtos = inoutForm.getInoutDtos();
            this.inoutService.saveInout(inoutDtos);
            Map<String, Object> successResponse = new HashMap<>();

            successResponse.put("status", "success");
            successResponse.put("message", "정상적으로 저장되었습니다.");
            successResponse.put("redirectUrl", "/pd/inout/inoutlist");

            return ResponseEntity.ok().body(successResponse); // 저장 후 목록 페이지로 리다이렉트

        } catch (Exception e){

            Map<String, Object> errorResponse = new HashMap<>();

            errorResponse.put("status", "error");
            errorResponse.put("message", String.format("저장에 실패 하였습니다.[%s]", e.getMessage()));

            errorResponse.put("redirectUrl", "/pd/inout/create");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }*/
}


