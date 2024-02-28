package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.Form.OrderForm;
import com.erpproject.sixbeam.pd.dto.OrderDto;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.OrderEntity;
import com.erpproject.sixbeam.pd.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/pd/order")
@RequiredArgsConstructor
@Controller
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orderlist")
    public String list(Model model) {

        // 서비스를 통해 모든 품목을 가져옴
        List<OrderEntity> orderEntities = orderService.getList();

        // 가져온 품목 리스트를 모델에 담음
        model.addAttribute("orderEntities", orderEntities);

        // 완품 리스트 뷰페이지 반환
        return "contents/pd/order_list";
    }

    @GetMapping("/create")
    public String orderCreate(Model model) {

        OrderForm form = new OrderForm();
        List<EmpInfoEntity> empInfoEntity = orderService.getEmpList();
        List<ItemEntity> itemEntity =  orderService.getItemList();

        form.getOrderDtos().add(new OrderDto());
        form.getOrderDtos().add(new OrderDto());

        model.addAttribute("getEmpList",empInfoEntity);
        model.addAttribute("getItemList",itemEntity);
        model.addAttribute("orderForm",form);

        return "contents/pd/order_form";
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveorder(@ModelAttribute OrderForm orderForm) {

        try {

            List<OrderDto> orderDtos = orderForm.getOrderDtos();
            this.orderService.saveOrder(orderDtos);
            Map<String, Object> successResponse = new HashMap<>();

            successResponse.put("status", "success");
            successResponse.put("message", "정상적으로 저장되었습니다.");
            successResponse.put("redirectUrl", "/pd/order/orderlist");

            return ResponseEntity.ok().body(successResponse); // 저장 후 목록 페이지로 리다이렉트

        } catch (Exception e){

            Map<String, Object> errorResponse = new HashMap<>();

            errorResponse.put("status", "error");
            errorResponse.put("message", String.format("저장에 실패 하였습니다.[%s]", e.getMessage()));

            errorResponse.put("redirectUrl", "/pd/order/create");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
