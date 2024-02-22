package com.erpproject.sixbeam.ss.service;

import com.erpproject.sixbeam.ss.dto.SaleDto;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.form.SaleForm;
import com.erpproject.sixbeam.ss.repository.EstimateRepository;
import com.erpproject.sixbeam.ss.repository.SaleRepository;
import com.erpproject.sixbeam.st.RowAddedEvent;
import com.erpproject.sixbeam.st.repository.WhmoveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RequiredArgsConstructor
@Service
public class SaleService {
    private final SaleRepository saleRepository;
    private final EstimateRepository estimateRepository;
    private final WhmoveRepository whmoveRepository;
    private final EstimateService estimateService;
 //   private final ApplicationEventPublisher event;//[이벤트리스너]

    public List<EstimateEntity> getEstimateList() {

        return estimateService.getList();
    }

    public List<EstimateEntity> getEstimateIdList(String id) {

        return this.estimateRepository.findByEstimateCd(id);
    }

    public List<SaleEntity> getList() {
        return this.saleRepository.findAll();
    }

    public Optional<SaleEntity> getId(String id) {
        return this.saleRepository.findById(id);
    }

    public void create(SaleDto saleDto) {
        SaleEntity saleEntity = saleDto.toEtity();
        String saleCd = generateNewSaleCd(saleEntity.getSaleUploadDt());
        saleEntity.setSaleCd(saleCd);
        saleRepository.save(saleEntity);
    //    event.publishEvent(new RowAddedEvent(this,saleEntity));//[이벤트리스너]
    }

    public void update(SaleDto saleDto) {
            Optional<SaleEntity> optionalSaleEntity = saleRepository.findById(saleDto.getSaleCd());
            SaleEntity saleEntity=optionalSaleEntity.get();
            saleRepository.save(saleEntity);
    }
    public void delete(SaleForm saleForm) {
        List<SaleDto> saleDtos = saleForm.getSaleDtos();
        for (SaleDto saleDto : saleDtos) {
            Optional<SaleEntity> optionalSaleEntity = saleRepository.findById(saleDto.getSaleCd());
            SaleEntity saleEntity=optionalSaleEntity.get();
            saleRepository.save(saleEntity);
        }
    }

    private String generateNewSaleCd(LocalDate saleDate) {
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "SS" + saleDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "-";

        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = saleRepository.getMaxSaleCd(saleDate);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;

        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%03d", sequenceNumber);

        return prefix + sequenceNumberString;
    }
}
