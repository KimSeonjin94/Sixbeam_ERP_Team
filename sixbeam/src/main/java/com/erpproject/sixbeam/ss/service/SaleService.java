package com.erpproject.sixbeam.ss.service;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.entity.SalesEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import com.erpproject.sixbeam.ss.dto.SaleAndEstimateDto;
import com.erpproject.sixbeam.ss.dto.SaleDto;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.repository.EstimateRepository;
import com.erpproject.sixbeam.ss.repository.SaleRepository;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.event.WhmoveRowAddedEvent;
import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import com.erpproject.sixbeam.st.event.WhmoveRowDeletedEvent;
import com.erpproject.sixbeam.st.event.WhmoveRowUpdatedEvent;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RequiredArgsConstructor
@Service
public class SaleService {
    private final SaleRepository saleRepository;
    private final EstimateRepository estimateRepository;
    private final WhregistRepository whregistRepository;
    private final EstimateService estimateService;
    private final ApplicationEventPublisher addEvent;
    private final ApplicationEventPublisher deleteEvent;
    private final ApplicationEventPublisher updateEvent;

    public List<SaleEntity> getList() {
        return this.saleRepository.findAll();
    }

    public Optional<SaleEntity> getId(String id) {
        return this.saleRepository.findById(id);
    }


    @Transactional(rollbackFor = Exception.class)
    public void create(SaleDto saleDto) {
        try {
            SaleEntity saleEntity = saleDto.toEtity();
            String saleCd = generateNewSaleCd(saleEntity.getSaleUploadDt());
            saleEntity.setSaleCd(saleCd);
            WhregistEntity whregistEntity=whregistRepository.findByWhregistCd(saleEntity.getWhregistEntity().getWhregistCd()).get(0);
            if(whregistEntity==null){
                throw new IllegalArgumentException("없는 창고코드입니다.");
            }
            saleEntity.setWhregistEntity(whregistEntity);
            List<EstimateEntity> estimateEntity = estimateRepository.findByEstimateCd(saleEntity.getEstimateCd());
            Optional<SaleEntity> optionalSaleEntity=saleRepository.findByEstimateCd(saleEntity.getEstimateCd());
            if(estimateEntity.isEmpty()){
                throw new IllegalArgumentException("없는 견적코드입니다.");
            }
            if(optionalSaleEntity.isPresent()){
                throw new IllegalArgumentException("이미 판매처리된 견적입니다.");
            }
            saleRepository.save(saleEntity);
            WhmoveRowAddedEvent<SaleEntity> saleEvent = new WhmoveRowAddedEvent<>(this, saleEntity);
            addEvent.publishEvent(saleEvent);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
    @Transactional
    public void update(SaleDto saleDto) {
        Optional<SaleEntity> optionalSaleEntity = saleRepository.findById(saleDto.getSaleCd());
        SaleEntity saleEntity=optionalSaleEntity.get();
        Optional<WhregistEntity> whregistEntity =whregistRepository.findById(saleDto.getWhregistEntity().getWhregistCd());
        if(whregistEntity.isPresent()) {
            saleEntity.setWhregistEntity(whregistEntity.get());
            saleRepository.save(saleEntity);
        }else{
            throw new IllegalArgumentException("잘못된 선택입니다");
        }
        WhmoveRowUpdatedEvent<SaleEntity> saleEvent = new WhmoveRowUpdatedEvent<>(this, saleEntity);
        updateEvent.publishEvent(saleEvent);
    }
    @Transactional
    public void delete(List<String> saleCds) {
        List<SaleEntity> saleEntitiesToDelete = new ArrayList<>();
        for (String saleCd : saleCds) {
            Optional<SaleEntity> optionalSaleEntity = saleRepository.findById(saleCd);
            SaleEntity saleEntity=optionalSaleEntity.get();
            if(saleEntity.isSaleBillingSt()){
                throw new IllegalStateException("출고 진행이 되어 삭제 불가 합니다.");
            }else {
                saleRepository.delete(saleEntity);
                saleEntitiesToDelete.add(saleEntity);
            }
        }
        WhmoveRowDeletedEvent<SaleEntity> saleDeletedEvent = new WhmoveRowDeletedEvent<>(this, saleEntitiesToDelete);
        deleteEvent.publishEvent(saleDeletedEvent);
    }

    public List<SaleEntity> getSales(AccountEntity accountEntity){
        List<EstimateEntity> estimateEntities=estimateRepository.findByAccountEntity(accountEntity);
        List<SaleEntity> saleEntities=new ArrayList<>();
        for(EstimateEntity estimateEntity: estimateEntities){
            Optional<SaleEntity> OpSaleEntity=saleRepository.findByEstimateCd(estimateEntity.getEstimateCd());
            SaleEntity saleEntity=OpSaleEntity.get();
            if(!saleEntity.isSaleBillingSt()){
                saleEntities.add(saleEntity);
            }
        }
        return saleEntities;
    }
    public List<SaleAndEstimateDto> getRelease(String saleShippingSt){
        List<SaleEntity> saleEntities=saleRepository.findBySaleShippingSt(saleShippingSt);
        List<SaleAndEstimateDto> saleAndEstimateDtos=new ArrayList<>();
        for(SaleEntity saleEntity:saleEntities){
            List<EstimateEntity> estimateEntities = estimateRepository.findByEstimateCd(saleEntity.getEstimateCd());
            SaleAndEstimateDto saleAndEstimateDto=new SaleAndEstimateDto();
            saleAndEstimateDto.setEstimateEntity(estimateEntities);
            saleAndEstimateDto.setSaleEntity(saleEntity);
            saleAndEstimateDtos.add(saleAndEstimateDto);
        }
        return saleAndEstimateDtos;
    }

    private String generateNewSaleCd(LocalDate saleDate) {
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "SS" + saleDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-";

        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = saleRepository.getMaxSaleCd(saleDate);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;

        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);

        return prefix + sequenceNumberString;
    }

    public void addRowRelease(ReleaseEntity releaseEntity) {
        Optional<SaleEntity> optionalSaleEntity=saleRepository.findById(releaseEntity.getSaleEntity().getSaleCd());
        if(optionalSaleEntity.isPresent()){
            SaleEntity saleEntity=optionalSaleEntity.get();
            saleEntity.setSaleShippingSt("출고완료");
            saleEntity.setSaleShippingDt(LocalDate.now());
            saleRepository.save(saleEntity);
        }
    }

    public void addRowSales(SaleEntity saleEntity) {
            saleEntity.setSaleBillingDt(LocalDate.now());
            saleEntity.setSaleBillingSt(true);
            saleEntity.setSalePaymentDt(LocalDate.now());
            saleRepository.save(saleEntity);

    }
}
