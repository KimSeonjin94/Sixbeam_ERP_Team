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

    public List<InoutEntity> getList() {

        return inoutRepository.findAll();
    }

    public List<EmpInfoEntity> getEmpList() {

        return empInfoRepository.findAll();
    }

    public List<ItemEntity> getItemList() {

        return itemRepository.findAll();
    }

    public List<WhregistEntity> getWhList() {

        return whregistRepository.findAll();
    }

    public List<OrderEntity> getOdList() {

        return orderRepository.findAll();
    }

    public List<InoutEntity> getIdList(String inoutCd) {

        return inoutRepository.findByInoutCmptCd(inoutCd);
    }

    public List<InoutEntity> getFalseList(Model model) {

        List<InoutEntity> falseorderSt = inoutRepository.findByOrderStFalse();

        return inoutRepository.saveAll(falseorderSt);
    }

    public void saveInout(List<InoutDto> inoutDtos) {

        for (InoutDto inoutDto : inoutDtos) {
            EmpInfoEntity empInfoEntity = empInfoRepository.findById(inoutDto.getEmpInfoEntity().getEmpInfoId())
                    .orElseThrow(() -> new EntityNotFoundException("사원코드를 찾을 수 없습니다."));
            ItemEntity itemEntity = itemRepository.findById(inoutDto.getItemEntity().getItemCd())
                    .orElseThrow(() -> new EntityNotFoundException("품목코드를 찾을 수 없습니다."));
            OrderEntity orderEntity = orderRepository.findById(inoutDto.getOrderEntity().getOrderCd())
                    .orElseThrow(() -> new EntityNotFoundException("작업지시코드를 찾을 수 없습니다."));
            WhregistEntity whregistEntity = whregistRepository.findById(inoutDto.getWhregistEntity().getWhregistCd()).
                    orElseThrow(() -> new EntityNotFoundException("창고코드를 찾을 수 없습니다."));

            inoutDto.setEmpInfoEntity(empInfoEntity);
            inoutDto.setItemEntity(itemEntity);

            InoutEntity inoutEntity = inoutDto.toEntity();
            String newinoutCmptCd = generateNewInoutCmptCd(inoutDto.getInoutDt());
            inoutEntity.setInoutCmptCd(newinoutCmptCd);
            inoutRepository.save(inoutEntity);
        }
    }

    private String generateNewInoutCmptCd(LocalDate inoutDate) {
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "CMPT" + inoutDate.format(DateTimeFormatter.ofPattern("yyMMdd")) + "-";

        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = inoutRepository.getMaxInoutCmptCd(inoutDate);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;

        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%03d", sequenceNumber);

        return prefix + sequenceNumberString;
    }
}
