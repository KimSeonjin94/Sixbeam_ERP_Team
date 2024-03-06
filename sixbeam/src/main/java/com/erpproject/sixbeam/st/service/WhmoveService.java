package com.erpproject.sixbeam.st.service;

import com.erpproject.sixbeam.pur.entity.InputEntity;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    //[이벤트리스너_As]-----------------------------------------------
    //-등록
    public void addRowAs(AsEntity asEntity) {//등록
        WhmoveEntity whmoveEntity = new WhmoveEntity();
        String newWhmoveCd = generateNewWhmoveAsCd(asEntity.getAsDt());
        whmoveEntity.setWhmoveDt(asEntity.getAsDt());
        whmoveEntity.setAsEntity(asEntity);
        whmoveEntity.setEmpInfoEntity(asEntity.getEmpInfoEntity());
        whmoveEntity.setItemEntity(asEntity.getItemEntity());
        whmoveEntity.setWhregistEntity(asEntity.getWhregistEntity());
        whmoveEntity.setWhmoveAmt(asEntity.getAsAmt());
        whmoveEntity.setWhmoveGb("입고"); // 입고로 고정
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
        WhmoveEntity tempAs = whmoveRepository.ByAsCd(asEntity);
        WhmoveEntity whmoveEntity = new WhmoveEntity();
        whmoveEntity.setWhmoveDt(tempAs.getWhmoveDt());
        whmoveEntity.setAsEntity(tempAs.getAsEntity());
        whmoveEntity.setEmpInfoEntity(tempAs.getEmpInfoEntity());
        whmoveEntity.setItemEntity(tempAs.getItemEntity());
        whmoveEntity.setWhregistEntity(tempAs.getWhregistEntity());
        whmoveEntity.setWhmoveGb(tempAs.getWhmoveGb());
        whmoveEntity.setWhmoveCd(tempAs.getWhmoveCd());
        whmoveEntity.setWhmoveAmt(asEntity.getAsAmt()); //As테이블에서 변경된 수량만 반영
        tempAs = whmoveEntity;
        whmoveRepository.save(tempAs);
        CheckRowUpdatedEvent<WhmoveEntity> whmoveEvent = new CheckRowUpdatedEvent<>(this, tempAs);
        updateEvent.publishEvent(whmoveEvent);
    }
    //-삭제
    @Transactional
    public void deleteRowAs(List<AsEntity> asEntities){ //삭제
        List<WhmoveEntity> whmoveEntitiesToDelete = new ArrayList<>();
        for (AsEntity asEntity : asEntities) {
            List<WhmoveEntity> whmoveEntities = whmoveRepository.findByAsEntity(asEntity);
            whmoveEntitiesToDelete.addAll(whmoveEntities);
            whmoveRepository.deleteAll(whmoveEntities);
        }
        CheckRowDeletedEvent<WhmoveEntity> whDeletedEvent = new CheckRowDeletedEvent<>(this, whmoveEntitiesToDelete);
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
            whmoveEntity.setSaleEntity(saleEntity);
            whmoveEntity.setEmpInfoEntity(estimateEntity.getEmpInfoEntity());// 담당자(견적테이블 담당자)
            whmoveEntity.setItemEntity(estimateEntity.getItemEntity());//품목(견적테이블 품목)
            whmoveEntity.setWhregistEntity(saleEntity.getWhregistEntity());
            whmoveEntity.setWhmoveAmt(estimateEntity.getEstimateAmt());//수량(견적테이블 수량)
            whmoveEntity.setWhmoveGb("출고");
            String newWhmoveCd = generateNewWhmoveSaleCd(saleEntity.getSaleUploadDt());
            whmoveEntity.setWhmoveCd(newWhmoveCd);
            whmoveRepository.save(whmoveEntity);
        }
    }
    public void updateRowSale(SaleEntity saleEntity) { //수정
        WhmoveEntity tempSale = whmoveRepository.BySaleCd(saleEntity);
        WhmoveEntity whmoveEntity = new WhmoveEntity();
        whmoveEntity.setWhmoveDt(tempSale.getWhmoveDt());
        whmoveEntity.setAsEntity(tempSale.getAsEntity());
        whmoveEntity.setEmpInfoEntity(tempSale.getEmpInfoEntity());
        whmoveEntity.setItemEntity(tempSale.getItemEntity());
        whmoveEntity.setWhregistEntity(tempSale.getWhregistEntity());
        whmoveEntity.setWhmoveGb(tempSale.getWhmoveGb());
        whmoveEntity.setWhmoveCd(tempSale.getWhmoveCd());
//        whmoveEntity.setWhmoveAmt(saleEntity); //sale테이블에서 변경된 수량만 반영
        tempSale = whmoveEntity;
        whmoveRepository.save(tempSale);
        CheckRowUpdatedEvent<WhmoveEntity> whmoveEvent = new CheckRowUpdatedEvent<>(this, tempSale);
        updateEvent.publishEvent(whmoveEvent);
    }
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
    public void deleteRowSale(List<SaleEntity> saleEntities) { //삭제
        List<WhmoveEntity> whmoveEntitesToDelete = new ArrayList<>();
        for (SaleEntity saleEntity : saleEntities) {
            List<WhmoveEntity> whmoveEntities = whmoveRepository.findBySaleEntity(saleEntity);
            whmoveEntitesToDelete.addAll(whmoveEntities);
            whmoveRepository.deleteAll(whmoveEntities);
        }
        CheckRowDeletedEvent<WhmoveEntity> saleDeletedEvent = new CheckRowDeletedEvent<>(this, whmoveEntitesToDelete);
        deleteEvent.publishEvent(saleDeletedEvent);
    }
    //[이벤트리스너_Sale]---------------------------------------------

    //[이벤트리스너_Input]---------------------------------------------
    public void addRowInput(InputEntity inputEntity) { //등록
        WhmoveEntity whmoveEntity = new WhmoveEntity();
        String newWhmoveCd = generateNewInputCd(inputEntity.getInputPurDt());
        whmoveEntity.setWhmoveDt(inputEntity.getInputPurDt());
        whmoveEntity.setInputEntity(inputEntity);
        whmoveEntity.setEmpInfoEntity(inputEntity.getOrinputEntity().getEmpInfoEntity());// 담당자(견적테이블 담당자)
        whmoveEntity.setItemEntity(inputEntity.getOrinputEntity().getItemEntity());//품목(견적테이블 품목)
        whmoveEntity.setWhregistEntity(inputEntity.getWhregistEntity());
        whmoveEntity.setWhmoveAmt(inputEntity.getOrinputEntity().getOrinputAmt());//수량(견적테이블 수량)
        whmoveEntity.setWhmoveGb("입고");
        whmoveEntity.setWhmoveCd(newWhmoveCd);
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
        WhmoveEntity tempInput = whmoveRepository.ByInputCd(inputEntity);
        WhmoveEntity whmoveEntity = new WhmoveEntity();
        whmoveEntity.setWhmoveDt(tempInput.getWhmoveDt());
        whmoveEntity.setAsEntity(tempInput.getAsEntity());
        whmoveEntity.setEmpInfoEntity(tempInput.getEmpInfoEntity());
        whmoveEntity.setItemEntity(tempInput.getItemEntity());
        whmoveEntity.setWhregistEntity(tempInput.getWhregistEntity());
        whmoveEntity.setWhmoveGb(tempInput.getWhmoveGb());
        whmoveEntity.setWhmoveCd(tempInput.getWhmoveCd());
        whmoveEntity.setWhmoveAmt(inputEntity.getOrinputEntity().getOrinputAmt()); //Input테이블에서 변경된 수량만 반영
        tempInput = whmoveEntity;
        whmoveRepository.save(tempInput);
        CheckRowUpdatedEvent<WhmoveEntity> whmoveEvent = new CheckRowUpdatedEvent<>(this, tempInput);
        updateEvent.publishEvent(whmoveEvent);
    }
    @Transactional
    public void deleteRowInput(List<InputEntity> inputEntities) { //삭제
        List<WhmoveEntity> whmoveEntitesToDelete = new ArrayList<>();
        for (InputEntity inputEntity : inputEntities) {
            List<WhmoveEntity> whmoveEntities = whmoveRepository.findByInputEntity(inputEntity);
            whmoveEntitesToDelete.addAll(whmoveEntities);
            whmoveRepository.deleteAll(whmoveEntities);
        }
        CheckRowDeletedEvent<WhmoveEntity> inputDeletedEvent = new CheckRowDeletedEvent<>(this, whmoveEntitesToDelete);
        deleteEvent.publishEvent(inputDeletedEvent);
    }
}