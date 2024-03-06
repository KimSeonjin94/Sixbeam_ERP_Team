package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import com.erpproject.sixbeam.pd.Form.OrderForm;
import com.erpproject.sixbeam.pd.dto.OrderDto;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.OrderEntity;
import com.erpproject.sixbeam.pd.repository.FitemRepository;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final EmpInfoRepository empInfoRepository;
    private final ItemRepository itemRepository;
    private final FitemRepository fitemRepository;
    private final EmpInfoService empInfoService;
    private final BomService bomService;

    public List<OrderEntity> getList() {

        return orderRepository.findAll();
    }

    public List<EmpInfoEntity> getEmpList() {

        return empInfoRepository.findAll();
    }

    public List<ItemEntity> getFitemList() {

        return itemRepository.findByItemCdStartingWith("F");
    }

    /*public List<OrderEntity> getIdList(String orderCd) {

        return orderRepository.findById(orderCd);
    }*/

    public void getOrderList(Model model) {

        OrderForm orderForm = new OrderForm();

        // 데이터 가져오기
        List<OrderEntity> getorderEntity = getList();
        List<EmpInfoEntity> empInfoEntity = empInfoRepository.findAll();
        List<ItemEntity> getFitemEntity = itemRepository.findByItemCdStartingWith("F");

        // form 데이터 입력란 추가
        orderForm.getOrderDtos().add(new OrderDto());
        orderForm.getOrderDtos().add(new OrderDto());

        // 모델에 데이터 등록
        model.addAttribute("getorderlist", getorderEntity);
        model.addAttribute("getFitemlist", getFitemEntity);
    }


    public void saveOrder(List<OrderDto> orderDtos) {

        for (OrderDto orderDto : orderDtos) {
            EmpInfoEntity empInfoEntity = empInfoRepository.findById(orderDto.getEmpInfoEntity().getEmpInfoId())
                    .orElseThrow(() -> new EntityNotFoundException("회원코드를 찾을 수 없습니다."));
            ItemEntity itemEntity = itemRepository.findById(orderDto.getItemEntity().getItemCd())
                    .orElseThrow(() -> new EntityNotFoundException("품목코드를 찾을 수 없습니다."));

            orderDto.setEmpInfoEntity(empInfoEntity);
            orderDto.setItemEntity(itemEntity);

            OrderEntity orderEntity = orderDto.toEntity();
            String newOrderCd = generateNewOrderCd(orderDto.getOrderInstDt());
            orderEntity.setOrderCd(newOrderCd);
            orderRepository.save(orderEntity);
        }
    }


    public ResponseEntity<?> createOrderDto(@ModelAttribute OrderForm orderForm) {

        List<OrderDto> orderDtos = orderForm.getOrderDtos();

        try {
            create(orderDtos);
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("redirctUrl", "/pd/order/new"));

        } catch (Exception e) {

            Map<String, Object> errorResponse = new HashMap<>();

            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다. 입력화면으로 돌아갑니다");
            errorResponse.put("redirectUrl", "/pd/bom/new");

            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    public void create(List<OrderDto> orderDtos) {

        List<OrderEntity> orderEntities = new ArrayList<>();

        String newOrderCd = generateNewOrderCd(orderDtos.get(0).getOrderInstDt());

        for (OrderDto orderDto : orderDtos) {

            EmpInfoEntity empInfoEntity = empInfoRepository.findById(orderDto.getEmpInfoEntity().getEmpInfoId())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            ItemEntity itemEntity = itemRepository.findById(orderDto.getItemEntity().getItemCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));

            orderDto.setEmpInfoEntity(empInfoEntity);
            orderDto.setItemEntity(itemEntity);

            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setOrderCd(newOrderCd);
            orderEntity = orderDto.toEntity();
            orderEntities.add(orderEntity);
        }
        orderRepository.saveAll(orderEntities);
    }

    private String generateNewOrderCd(LocalDate inputDate) {
        // 현재 날짜를 기반으로 새로운 구매 코드 생성
        String prefix = "OD" + inputDate.format(DateTimeFormatter.ofPattern("yyyy")) + "-";

        // DB에서 최대 구매 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = orderRepository.getMaxOrderCd(inputDate);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;

        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%03d", sequenceNumber);

        return prefix + sequenceNumberString;
    }

    public void readyOrderForm(Model model) {

        OrderForm orderForm = new OrderForm();

        List<EmpInfoEntity> getemplist = getEmpList();
        List<ItemEntity> getFitemlist = getFitemList();
        List<OrderEntity> orderEntities = getList();

        orderForm.getOrderDtos().add(new OrderDto());

        model.addAttribute("getempinfo", getemplist);
        model.addAttribute("getFitemlist", getFitemlist);
        model.addAttribute("orderSt", orderEntities);
    }

    public void changeOrderStatus(List<String> orderCds) {

        // 작업 지시 코드 목록을 반복하여 각 주문의 상태를 변경
        for (String orderCd : orderCds) {

            // 코드를 사용하여 주문을 조회
            OrderEntity order = orderRepository.findByOrderCd(orderCd);
            if (order.isOrderSt()) {

                order.setOrderSt(false);
                orderRepository.save(order);
            } else {

                order.setOrderSt(true);
                orderRepository.save(order);
            }
        }
    }
}
