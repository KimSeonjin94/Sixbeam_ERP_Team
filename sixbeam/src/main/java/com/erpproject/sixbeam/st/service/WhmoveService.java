package com.erpproject.sixbeam.st.service;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.ss.dto.SaleAndEstimateDto;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.repository.EstimateRepository;
import com.erpproject.sixbeam.st.event.CheckRowAddedEvent;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.event.CheckRowDeletedEvent;
import com.erpproject.sixbeam.st.event.CheckRowUpdatedEvent;
import com.erpproject.sixbeam.st.event.WhmoveRowDeletedEvent;
import com.erpproject.sixbeam.st.repository.WhmoveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RequiredArgsConstructor
@Service
public class WhmoveService {

    private final WhmoveRepository whmoveRepository;
    private final EstimateRepository estimateRepository;
    private final ApplicationEventPublisher addEvent;
    private final ApplicationEventPublisher deleteEvent;
    private final ApplicationEventPublisher updateEvent;

    public List<WhmoveEntity> getList() {
        return this.whmoveRepository.findAll();
    }

    public WhmoveEntity getWhmoveEntity(String whmoveCd) {
        Optional<WhmoveEntity> whmoveEntity = this.whmoveRepository.findById(whmoveCd);
        if (whmoveEntity.isPresent()) {
            return whmoveEntity.get();
        } else {
            throw new DataNotFoundException("whmoveEntity not found");
        }
    }

    //[이벤트리스너_As]-------------------------------------------완료
    //-등록
    public void addRowAs(AsEntity asEntity) {//등록
        WhmoveEntity whmoveEntity = new WhmoveEntity();
        String newWhmoveCd = generateNewWhmoveAsCd(asEntity.getAsDt());
        whmoveEntity.setWhmoveDt(asEntity.getAsDt());
        whmoveEntity.setAsCd(asEntity.getAsCd());
        whmoveEntity.setEmpInfoEntity(asEntity.getEmpInfoEntity());
        whmoveEntity.setItemEntity(asEntity.getItemEntity());
        whmoveEntity.setWhregistEntity(asEntity.getWhregistEntity());
        whmoveEntity.setWhmoveAmt(asEntity.getAsAmt());
        whmoveEntity.setWhmoveGb("입고"); // 입고로 고정
        whmoveEntity.setInoutCmptCd(null);
        whmoveEntity.setSaleCd(null);
        whmoveEntity.setInputPurCd(null);
        whmoveEntity.setWhmoveCd(newWhmoveCd);
        whmoveRepository.save(whmoveEntity);
        CheckRowAddedEvent<WhmoveEntity> whmoveEvent = new CheckRowAddedEvent<>(this, whmoveEntity);
        addEvent.publishEvent(whmoveEvent);
    }

    private String generateNewWhmoveAsCd(LocalDate asDate) { //기본키 자동생성
        String prefix = "WHM" + asDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-";
        String maxCd = whmoveRepository.getMaxWhmoveCd(asDate);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;
        String sequenceNumberString = String.format("%04d", sequenceNumber);
        return prefix + sequenceNumberString;
    }

    public void updateRowAs(AsEntity asEntity) { //수정
        WhmoveEntity tempAs = whmoveRepository.ByAsCd(asEntity.getAsCd());
        WhmoveEntity whmoveEntity = new WhmoveEntity();
        whmoveEntity.setWhmoveDt(tempAs.getWhmoveDt());
        whmoveEntity.setAsCd(tempAs.getAsCd());
        whmoveEntity.setEmpInfoEntity(tempAs.getEmpInfoEntity());
        whmoveEntity.setItemEntity(tempAs.getItemEntity());
        whmoveEntity.setWhregistEntity(tempAs.getWhregistEntity());
        whmoveEntity.setWhmoveGb(tempAs.getWhmoveGb());
        whmoveEntity.setWhmoveCd(tempAs.getWhmoveCd());
        whmoveEntity.setWhmoveAmt(asEntity.getAsAmt()); //As테이블에서 변경된 수량만 반영
        whmoveEntity.setInoutCmptCd(null);
        whmoveEntity.setSaleCd(null);
        whmoveEntity.setInputPurCd(null);
        tempAs = whmoveEntity;
        whmoveRepository.save(tempAs);
        CheckRowUpdatedEvent<WhmoveEntity> whmoveEvent = new CheckRowUpdatedEvent<>(this, tempAs);
        updateEvent.publishEvent(whmoveEvent);
    }

    //-삭제
    @Transactional
    public void deleteRowAs(List<String> asEntities){ //삭제
        List<WhmoveEntity> asEntitiesToDelete = new ArrayList<>();
        for (String asEntity : asEntities) {
            List<WhmoveEntity> tempAsList = whmoveRepository.findByAsCd(asEntity);
            asEntitiesToDelete.addAll(tempAsList);
            whmoveRepository.deleteAll(tempAsList);
        }
        CheckRowDeletedEvent<WhmoveEntity> whDeletedEvent = new CheckRowDeletedEvent<>(this, asEntitiesToDelete);
        deleteEvent.publishEvent(whDeletedEvent);
    }
    //[이벤트리스너_As]-----------------------------------------------

    //[이벤트리스너_Sale]---------------------------------------------
    //-등록
    public void addRowSale(SaleEntity saleEntity) { //등록
        List<EstimateEntity> estimateEntities = estimateRepository.findByEstimateCd(saleEntity.getEstimateCd());
        for (EstimateEntity estimateEntity : estimateEntities) {
            WhmoveEntity whmoveEntity = new WhmoveEntity();
            whmoveEntity.setWhmoveDt(saleEntity.getSaleUploadDt());
            whmoveEntity.setSaleCd(saleEntity.getSaleCd());
            whmoveEntity.setEmpInfoEntity(estimateEntity.getEmpInfoEntity());// 담당자(견적테이블 담당자)
            whmoveEntity.setItemEntity(estimateEntity.getItemEntity());//품목(견적테이블 품목)
            whmoveEntity.setWhregistEntity(saleEntity.getWhregistEntity());
            whmoveEntity.setWhmoveAmt(estimateEntity.getEstimateAmt());//수량(견적테이블 수량)
            whmoveEntity.setWhmoveGb("출고");
            whmoveEntity.setInoutCmptCd(null);
            whmoveEntity.setAsCd(null);
            whmoveEntity.setInputPurCd(null);
            String newWhmoveCd = generateNewWhmoveSaleCd(saleEntity.getSaleUploadDt());
            whmoveEntity.setWhmoveCd(newWhmoveCd);
            whmoveRepository.save(whmoveEntity);
            CheckRowAddedEvent<WhmoveEntity> whmoveEvent = new CheckRowAddedEvent<>(this, whmoveEntity);
            addEvent.publishEvent(whmoveEvent);
        }
    }

        public void updateRowSale(SaleEntity saleEntity) { //수정
        WhmoveEntity tempSale = whmoveRepository.BySaleCd(saleEntity.getSaleCd());
        tempSale.setWhmoveDt(tempSale.getWhmoveDt());
        tempSale.setSaleCd(tempSale.getSaleCd());
        tempSale.setEmpInfoEntity(tempSale.getEmpInfoEntity());
        tempSale.setItemEntity(tempSale.getItemEntity());
        tempSale.setWhregistEntity(saleEntity.getWhregistEntity());
        tempSale.setWhmoveGb(tempSale.getWhmoveGb());
        tempSale.setWhmoveCd(tempSale.getWhmoveCd());
        tempSale.setWhmoveAmt(tempSale.getWhmoveAmt());
        tempSale.setInoutCmptCd(null);
        tempSale.setAsCd(null);
        tempSale.setInputPurCd(null);
        whmoveRepository.save(tempSale);
        CheckRowUpdatedEvent<WhmoveEntity> whmoveEvent = new CheckRowUpdatedEvent<>(this, tempSale);
        updateEvent.publishEvent(whmoveEvent);
    }
//    public void updateRowSale(SaleEntity saleEntity) { //수정
//        List<WhmoveEntity> tempSale = whmoveRepository.BySaleCd(saleEntity.getSaleCd());
//        List<EstimateEntity> estimateEntities = estimateRepository.findByEstimateCd(saleEntity.getEstimateCd());
//        // ItemEntity를 키로 하고 EstimateEntity를 값으로 하는 맵 생성
//        Map<ItemEntity, EstimateEntity> itemToEstimateMap = new HashMap<>();
//        for (EstimateEntity estimateEntity : estimateEntities) {
//            itemToEstimateMap.put(estimateEntity.getItemEntity(), estimateEntity);
//        }
//
//        // tempSale 리스트의 각 WhmoveEntity에 대해 매핑된 EstimateEntity가 있는지 확인
//        for (WhmoveEntity whmoveEntity : tempSale) {
//            EstimateEntity matchedEstimate = itemToEstimateMap.get(whmoveEntity.getItemEntity());
//            if (matchedEstimate != null) {
//                whmoveEntity.setWhregistEntity(saleEntity.getWhregistEntity());
//                whmoveEntity.setWhmoveAmt(matchedEstimate.getEstimateAmt());
//            }
//        }
//        whmoveRepository.saveAll(tempSale);
//        CheckRowUpdatedEvent<List<WhmoveEntity>> whmoveEvent = new CheckRowUpdatedEvent<>(this, tempSale);
//        updateEvent.publishEvent(whmoveEvent);
//    }

    private String generateNewWhmoveSaleCd(LocalDate saleUploadDt) { //기본키 자동생성
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "WHM" + saleUploadDt.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-";
        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = whmoveRepository.getMaxWhmoveCd(saleUploadDt);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;
        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);
        return prefix + sequenceNumberString;
    }

    @Transactional
    public void deleteRowSale(List<String> saleEntities) { //삭제
        List<WhmoveEntity> saleEntitesToDelete = new ArrayList<>();
        for (String saleEntity : saleEntities) {
            List<WhmoveEntity> tempSaleList = whmoveRepository.findBySaleCd(saleEntity);
            saleEntitesToDelete.addAll(tempSaleList);
            whmoveRepository.deleteAll(tempSaleList);
        }
        CheckRowDeletedEvent<WhmoveEntity> saleDeletedEvent = new CheckRowDeletedEvent<>(this, saleEntitesToDelete);
        deleteEvent.publishEvent(saleDeletedEvent);
    }
    //[이벤트리스너_Sale]---------------------------------------------

    //[이벤트리스너_Input]----------------------------------------완료
    public void addRowInput(InputEntity inputEntity) { //등록
        WhmoveEntity whmoveEntity = new WhmoveEntity();
        String newWhmoveCd = generateNewInputCd(inputEntity.getInputPurDt());
        whmoveEntity.setWhmoveDt(inputEntity.getInputPurDt());
        whmoveEntity.setInputPurCd(inputEntity.getInputPurCd());
        whmoveEntity.setEmpInfoEntity(inputEntity.getOrinputEntity().getEmpInfoEntity());// 담당자(견적테이블 담당자)
        whmoveEntity.setItemEntity(inputEntity.getOrinputEntity().getItemEntity());//품목(견적테이블 품목)
        whmoveEntity.setWhregistEntity(inputEntity.getWhregistEntity());
        whmoveEntity.setWhmoveAmt(inputEntity.getOrinputEntity().getOrinputAmt());//수량(견적테이블 수량)
        whmoveEntity.setWhmoveGb("입고");
        whmoveEntity.setWhmoveCd(newWhmoveCd);
        whmoveEntity.setInoutCmptCd(null);
        whmoveEntity.setSaleCd(null);
        whmoveEntity.setAsCd(null);
        whmoveRepository.save(whmoveEntity);
        CheckRowAddedEvent<WhmoveEntity> whmoveEvent = new CheckRowAddedEvent<>(this, whmoveEntity);
        addEvent.publishEvent(whmoveEvent);
    }

    private String generateNewInputCd(LocalDate inputPurDt) {//기본키 자동생성
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "WHM" + inputPurDt.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-";
        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = whmoveRepository.getMaxWhmoveCd(inputPurDt);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;
        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);
        return prefix + sequenceNumberString;
    }

    public void updateRowInput(InputEntity inputEntity) { //수정
        WhmoveEntity tempInput = whmoveRepository.ByInputCd(inputEntity.getInputPurCd());
        tempInput.setWhmoveDt(tempInput.getWhmoveDt());
        tempInput.setInputPurCd(tempInput.getInputPurCd());
        tempInput.setEmpInfoEntity(tempInput.getEmpInfoEntity());
        tempInput.setItemEntity(tempInput.getItemEntity());
        tempInput.setWhregistEntity(inputEntity.getWhregistEntity());
        tempInput.setWhmoveGb(tempInput.getWhmoveGb());
        tempInput.setWhmoveCd(tempInput.getWhmoveCd());
        tempInput.setWhmoveAmt(inputEntity.getOrinputEntity().getOrinputAmt());
        tempInput.setInoutCmptCd(null);
        tempInput.setSaleCd(null);
        tempInput.setAsCd(null);
        whmoveRepository.save(tempInput);
        CheckRowUpdatedEvent<WhmoveEntity> whmoveEvent = new CheckRowUpdatedEvent<>(this, tempInput);
        updateEvent.publishEvent(whmoveEvent);
    }

    @Transactional
    public void deleteRowInput(List<String> inputIds) { //삭제
        List<WhmoveEntity> inputEntitesToDelete = new ArrayList<>();
        for (String inputId : inputIds) {
            List<WhmoveEntity> tempInputList = whmoveRepository.findByInputPurCd(inputId);
            inputEntitesToDelete.addAll(tempInputList);
            whmoveRepository.deleteAll(tempInputList);
        }
        CheckRowDeletedEvent<WhmoveEntity> inputDeletedEvent = new CheckRowDeletedEvent<>(this, inputEntitesToDelete);
        deleteEvent.publishEvent(inputDeletedEvent);
    }
}