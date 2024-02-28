package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.dto.EmpInfoDto;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.pd.dto.OrderDto;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.OrderEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.repository.OrderRepository;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final EmpInfoRepository empInfoRepository;
    private final ItemRepository itemRepository;

    public List<OrderEntity> getList() {

        return orderRepository.findAll();
    }

    public List<EmpInfoEntity> getEmpList() {

        return empInfoRepository.findAll();
    }

    public List<ItemEntity> getItemList() {

        return itemRepository.findAll();
    }

    public List<OrderEntity> getIdList(String orderCd) {

        return orderRepository.findByOrderCd(orderCd);
    }

    public void saveOrder(List<OrderDto> orderDtos) {

        for (OrderDto orderDto : orderDtos) {
            EmpInfoEntity empInfoEntity = empInfoRepository.findById(orderDto.getEmpInfoEntity().getEmpInfoId())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            ItemEntity itemEntity = itemRepository.findById(orderDto.getItemEntity().getItemCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));

            orderDto.setEmpInfoEntity(empInfoEntity);
            orderDto.setItemEntity(itemEntity);

            OrderEntity orderEntity = orderDto.toEntity();
            String newOrderCd = generateNewOrderCd(orderDto.getOrderInstDt());

            orderEntity.setOrderCd(newOrderCd);
            orderRepository.save(orderEntity);
        }
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
}
