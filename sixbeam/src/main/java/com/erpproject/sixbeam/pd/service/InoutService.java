package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.pd.dto.InoutDto;
import com.erpproject.sixbeam.pd.entity.InoutEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.OrderEntity;
import com.erpproject.sixbeam.pd.repository.InoutRepository;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.repository.OrderRepository;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InoutService {

    private final InoutRepository inoutRepository;
    private final ItemRepository itemRepository;
    private final EmpInfoRepository empInfoRepository;
    private final WhregistRepository whregistRepository;
    private final OrderRepository orderRepository;

    public List<InoutEntity> getList() {

        return inoutRepository.findAll();
    }

    public List<EmpInfoEntity> getEmpList() {

        return empInfoRepository.findAll();
    }

    public List<WhregistEntity> getWhList() {

        return whregistRepository.findAll();
    }

    public List<InoutEntity> getIdList(String inoutCd) {

        return inoutRepository.findByInoutCd(inoutCd);
    }

    public void saveInout(List<InoutDto> inoutDtos) {

        for (InoutDto inoutDto : inoutDtos) {
            EmpInfoEntity empInfoEntity = empInfoRepository.findByEmpInfoId(inoutDto.getEmpInfoEntity().getEmpInfoId())
                    .orElseThrow(() -> new EntityNotFoundException("Employer not found"));
            ItemEntity itemEntity = itemRepository.findById(inoutDto.getItemEntity().getItemCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            OrderEntity orderEntity = orderRepository.findByOrderCd(inoutDto.getOrderEntity().getOrderCd())
                    .orElseThrow(() -> new EntityNotFoundException("Order not found"));
            WhregistEntity whregistEntity = whregistRepository.findByWhregistCd(inoutDto.getWhregistEntity().getWhregistCd()).
                    orElseThrow(() -> new EntityNotFoundException("Warehouse not found"));

            inoutDto.setEmpInfoEntity(empInfoEntity);
            inoutDto.setItemEntity(itemEntity);

            InoutEntity inoutEntity = inoutDto.toEntity();
            String newinoutCd = generateNewInoutCd(inoutDto.getInoutDt());
            inoutEntity.setInoutCd(newInoutCd);
            inoutRepository.save(inoutEntity);
        }
    }

    private String generateNewInoutCd(LocalDate inoutDate) {
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "CMPT" + inoutDate.format(DateTimeFormatter.ofPattern("yyMMdd")) + "-";

        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = inoutRepository.getMaxInoutCd(inoutDate);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;

        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%03d", sequenceNumber);

        return prefix + sequenceNumberString;
    }
}
