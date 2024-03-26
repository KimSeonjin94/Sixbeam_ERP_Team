package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.pd.dto.InoutDto;
import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.InoutEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.OrderEntity;
import com.erpproject.sixbeam.pd.repository.BomRepository;
import com.erpproject.sixbeam.pd.repository.InoutRepository;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.repository.OrderRepository;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.event.WhmoveRowAddedEvent;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InoutService {

    private final InoutRepository inoutRepository;
    private final EmpInfoRepository empInfoRepository;
    private final ItemRepository itemRepository;
    private final WhregistRepository whregistRepository;
    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher addEvent;
    private final BomRepository bomRepository;

    public List<InoutEntity> getList() {

        return inoutRepository.findAll();
    }

    public InoutEntity getInout(String inoutCmptCd) {

        return inoutRepository.findByInoutCmptCd(inoutCmptCd);
    }

    // OrderEntity의 orderSt가 false인 경우에만 InoutEntity를 저장
    public void saveInout(String orderCd) {

        InoutDto inoutDto = new InoutDto();
        OrderEntity orderEntity = orderRepository.findById(orderCd)
                .orElseThrow(() -> new EntityNotFoundException("작업지시코드를 찾을 수 없습니다."));
        EmpInfoEntity empInfoEntity = empInfoRepository.findById(orderEntity.getEmpInfoEntity().getEmpInfoId())
                .orElseThrow(() -> new EntityNotFoundException("사원코드를 찾을 수 없습니다."));
        ItemEntity itemEntity = itemRepository.findById(orderEntity.getItemEntity().getItemCd())
                .orElseThrow(() -> new EntityNotFoundException("품목코드를 찾을 수 없습니다."));
        WhregistEntity whregistEntity = whregistRepository.findById("WHR1001")
                .orElseThrow(() -> new EntityNotFoundException("창고코드를 찾을 수 없습니다."));

        String newinoutCmptCd = generateNewInoutCmptCd(LocalDate.now());
        inoutDto.setInoutCmptCd(newinoutCmptCd);
        inoutDto.setEmpInfoEntity(empInfoEntity);
        inoutDto.setOrderEntity(orderEntity);
        inoutDto.setInoutDt(LocalDate.now());
        inoutDto.setWhregistEntity(whregistEntity);
        inoutDto.setItemEntity(itemEntity);

        InoutEntity inoutEntity = inoutDto.toEntity();
        inoutRepository.save(inoutEntity);

        WhmoveRowAddedEvent<InoutEntity> finoutEvent = new WhmoveRowAddedEvent<>(this, inoutEntity);
        addEvent.publishEvent(finoutEvent);

        String fitem = String.valueOf(itemEntity.getItemCd());
        List<BomEntity> bomEntity = bomRepository.findByFitemEntity_ItemCd(fitem);
        for (BomEntity bom : bomEntity) {
            itemEntity = itemRepository.findById(bom.getRitemEntity().getItemCd())
                    .orElseThrow(() -> new EntityNotFoundException("품목코드를 찾을 수 없습니다."));

            inoutDto.setItemEntity(itemEntity);

            InoutEntity temp = inoutDto.toEntity();
            inoutRepository.save(temp);

            WhmoveRowAddedEvent<InoutEntity> rinoutEvent = new WhmoveRowAddedEvent<>(this, temp);
            addEvent.publishEvent(rinoutEvent);
        }
    }

    private String generateNewInoutCmptCd(LocalDate inoutDate) {
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "CMPT" + inoutDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-";

        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = inoutRepository.getMaxInoutCmptCd(inoutDate);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;

        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);

        return prefix + sequenceNumberString;
    }
}
