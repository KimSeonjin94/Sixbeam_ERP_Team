package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.hr.service.EmpInfoService;
import com.erpproject.sixbeam.pd.Form.OrderForm;
import com.erpproject.sixbeam.pd.dto.OrderDto;
import com.erpproject.sixbeam.pd.entity.InoutEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.OrderEntity;
import com.erpproject.sixbeam.pd.repository.FitemRepository;
import com.erpproject.sixbeam.pd.repository.InoutRepository;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.repository.OrderRepository;
import groovyjarjarantlr4.v4.codegen.model.Loop;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final EmpInfoRepository empInfoRepository;
    private final ItemRepository itemRepository;
    private final InoutRepository inoutRepository;
    private final InoutService inoutService;

    public List<OrderEntity> getList() {

        return orderRepository.findAll();
    }

    public OrderEntity getOrder(String orderCd) {

        return orderRepository.findByOrderCd(orderCd);
    }

    public List<EmpInfoEntity> getEmpList() {

        return empInfoRepository.findAll();
    }

    public List<ItemEntity> getFitemList() {

        return itemRepository.findByItemCdStartingWith("F");
    }

    public void getOrderList(Model model) {

        OrderForm orderForm = new OrderForm();

        // 데이터 가져오기
        List<OrderEntity> getorderEntity = getList();

        // form 데이터 입력란 추가
        orderForm.getOrderDtos().add(new OrderDto());

        // 모델에 데이터 등록
        model.addAttribute("getOrderList", getorderEntity);
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

    @Transactional
    public void create(List<OrderDto> orderDtos) {

        for (OrderDto orderDto : orderDtos) {

            String newOrderCd = generateNewOrderCd(orderDtos.get(0).getOrderInstDt());

            EmpInfoEntity empInfoEntity = empInfoRepository.findById(orderDto.getEmpInfoEntity().getEmpInfoId())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            ItemEntity itemEntity = itemRepository.findById(orderDto.getItemEntity().getItemCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));

            orderDto.setEmpInfoEntity(empInfoEntity);
            orderDto.setItemEntity(itemEntity);

            OrderEntity orderEntity = orderDto.toEntity();
            orderEntity.setOrderCd(newOrderCd);
            orderRepository.save(orderEntity);
        }

    }

    private String generateNewOrderCd(LocalDate inputDate) {
        // 현재 날짜를 기반으로 새로운 작업 지시 코드 생성
        String prefix = "OD" + inputDate.format(DateTimeFormatter.ofPattern("yyyy")) + "-";

        // DB에서 최대 작업 지시 코드를 가져와서 숫자 부분 추출 후 +1 증가
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

    @Transactional
    public void changeOrderStatus(List<String> orderCds) {

        // 작업 지시 코드 목록을 반복하여 각 주문의 상태를 변경
        for (String orderCd : orderCds) {

            // 코드를 사용하여 주문을 조회
            OrderEntity order = orderRepository.findByOrderCd(orderCd);
            if (order.isOrderSt()) {

                order.setOrderSt(false);
                orderRepository.save(order);
                inoutService.saveInout(orderCd);
            } else {

                order.setOrderSt(true);
                orderRepository.save(order);
                inoutRepository.deleteByOrderCd(orderCd);
            }
        }
    }

    /*@Transactional
    public ResponseEntity<String> deleteOrder(List<String> orderCd) {

        try {
            for (String ordercd : orderCd) {
                orderRepository.findById(ordercd).ifPresent(orderRepository::delete);
            }
        } catch (DataAccessException e) {

            log.error("데이터베이스 조작 중 오류 발생", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("데이터베이스 조작 중 오류 발생");
        }
        return ResponseEntity.status(HttpStatus.OK).body("작업 지시서가 삭제되었습니다.");
    }*/

    @Transactional
    public ResponseEntity<String> deleteOrder(List<String> orderCd) {
        try {

            // 주문 목록을 반복하여 각 주문을 확인하고 삭제
            for (String ordercd : orderCd) {

                // orderRepository를 사용하여 orderCd로 주문을 찾습니다.
                Optional<OrderEntity> orderOptional = orderRepository.findById(ordercd);
                List<InoutEntity> allInoutEntities = inoutRepository.findAll();

                if (orderOptional.isPresent()) {

                    OrderEntity orderEntity = orderOptional.get();

                    // 모든 InoutEntity를 반복하여 해당 주문을 사용하는지 확인합니다.
                    boolean isInUse = false;

                    for (InoutEntity inoutEntity : allInoutEntities) {

                        // InoutEntity의 orderCd와 현재 주문의 orderCd를 비교합니다.
                        if (inoutEntity.getOrderEntity().getOrderCd().equals(orderEntity.getOrderCd())) {

                            // 일치하는 것이 발견되면 isInUse를 true로 설정하고 반복문을 탈출합니다.
                            isInUse = true;
                            break;
                        }
                    }
                    // isInUse가 true이면 해당 주문을 사용하는 InoutEntity가 있음을 의미합니다.
                    if (isInUse) {
                        // 메시지를 표시하고 반복문을 탈출합니다.
                        System.out.println("창고 불출한 작업지시서는 삭제할 수 없습니다.");
//                        break;

                    } else {
                        // isInUse가 false이면 해당 주문을 사용하는 InoutEntity가 없으므로 삭제
                        orderRepository.delete(orderEntity);
                        // 모든 주문이 성공적으로 삭제되었음을 클라이언트에게 알림
//                        return ResponseEntity.status(HttpStatus.OK).body("작업지시서가 삭제되었습니다.");
                    }
                }
            }
            // 주문 삭제 후 페이지 리다이렉트를 위해 ResponseEntity 반환
            return ResponseEntity.status(HttpStatus.FOUND).body("redirect:/pd/order/orderlist");
        } catch (DataAccessException e) {
            // 데이터베이스 조작 중 오류가 발생한 경우 서버 오류 메시지를 반환합니다.
            log.error("데이터베이스 조작 중 오류 발생", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("데이터베이스 조작 중 오류 발생");
        }
    }
}
