package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.Form.BomForm;
import com.erpproject.sixbeam.pd.Form.OrderForm;
import com.erpproject.sixbeam.pd.dto.BomDto;
import com.erpproject.sixbeam.pd.dto.OrderDto;
import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.OrderEntity;
import com.erpproject.sixbeam.pd.entity.RitemEntity;
import com.erpproject.sixbeam.pd.service.OrderService;
import com.erpproject.sixbeam.ss.dto.EstimateDto;
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

@RequestMapping("/pd/order")
@RequiredArgsConstructor
@Controller
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/new")
    public String newOrderDto(Model model) {

        OrderForm form = new OrderForm();
        List<EmpInfoEntity> empInfoEntities = orderService.getEmpList();
        List<ItemEntity> fitemEntities =  orderService.getFitemList();
        List<OrderEntity> orderEntities = orderService.getList();

        form.getOrderDtos().add(new OrderDto());

        model.addAttribute("getEmpList", empInfoEntities);
        model.addAttribute("getFitemList", fitemEntities);
        model.addAttribute("getOrderList", orderEntities);
        model.addAttribute("orderForm",form);

        orderService.readyOrderForm(model);
        return "contents/pd/order_form";
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrderDto(@ModelAttribute OrderForm orderForm) {

        List<OrderDto> orderDtos = orderForm.getOrderDtos();

        try {
            orderService.create(orderDtos);
            return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/pd/order/orderlist"));
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/pd/order/new");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @GetMapping("/orderlist")
    public String list(Model model) {

        orderService.getOrderList(model);

        return "contents/pd/order_list";
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

    @PostMapping("/turnboolean")
    public ResponseEntity<?> orderToChange(@RequestBody List<String> orderCds, RedirectAttributes redirectAttributes) {
        try {
            // 주문 상태를 변경하는 비즈니스 로직을 호출합니다.
            orderService.changeOrderStatus(orderCds);
            Map<String, Object> successResponse = new HashMap<>();

            successResponse.put("status", "success");
            successResponse.put("message", "정상적으로 저장되었습니다.");
            successResponse.put("redirectUrl", "/pd/order/orderlist");

            return ResponseEntity.ok().body(successResponse); // 저장 후 목록 페이지로 리다이렉트

        } catch (IllegalArgumentException e) {
            Map<String, Object> errorResponse = new HashMap<>();

            errorResponse.put("status", "error");
            errorResponse.put("message", String.format("저장에 실패 하였습니다.[%s]", e.getMessage()));
            errorResponse.put("redirectUrl", "/pd/order/order`list");
            return ResponseEntity.badRequest().body(errorResponse);
        }

    }
}