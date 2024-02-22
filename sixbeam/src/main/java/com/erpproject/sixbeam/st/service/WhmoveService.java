package com.erpproject.sixbeam.st.service;

import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.repository.EstimateRepository;
import com.erpproject.sixbeam.ss.repository.SaleRepository;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.repository.WhmoveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WhmoveService {

    private final WhmoveRepository whmoveRepository;
    private final EstimateRepository estimateRepository;

    public List<WhmoveEntity> getList() {
        return this.whmoveRepository.findAll();
    }
    public WhmoveEntity getWhmoveEntity(String whmoveCd){
        Optional<WhmoveEntity> whmoveEntity = this.whmoveRepository.findById(whmoveCd);
        if (whmoveEntity.isPresent()){
            return whmoveEntity.get();
        } else {
            throw new DataNotFoundException("whmoveEntity not found");
        }
    }
    //[이벤트리스너_As]-----------------------------------------------
    public void addRowAs(AsEntity asEntity) {
        WhmoveEntity whmoveEntity = new WhmoveEntity();
        String newWhmoveCd = generateNewWhmoveAsCd(asEntity.getAsDt());
        whmoveEntity.setWhmoveDt(asEntity.getAsDt());
        whmoveEntity.setEmpInfoEntity(asEntity.getEmpInfoEntity());
        whmoveEntity.setItemEntity(asEntity.getItemEntity());
        whmoveEntity.setWhregistEntity(asEntity.getWhregistEntity());
        whmoveEntity.setWhmoveAmt(asEntity.getAsAmt());
        whmoveEntity.setWhmoveGb("입고"); // 입고로 고정
        whmoveEntity.setWhmoveCd(newWhmoveCd);
        whmoveRepository.save(whmoveEntity);
    }
    private String generateNewWhmoveAsCd(LocalDate asDate) {
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "WHM" + asDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-";
        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = whmoveRepository.getMaxWhmoveCd(asDate);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;
        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);
        return prefix + sequenceNumberString;
    }
    //[이벤트리스너_As]-----------------------------------------------

    //[이벤트리스너_Sale]---------------------------------------------
    public void addRowSale(SaleEntity saleEntity) {
        List<EstimateEntity> estimateEntities = estimateRepository.findByEstimateCd(saleEntity.getEstimateCd());
        for(EstimateEntity estimateEntity : estimateEntities) {
            WhmoveEntity whmoveEntity = new WhmoveEntity();
            whmoveEntity.setWhmoveDt(saleEntity.getSaleUploadDt());
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
    private String generateNewWhmoveSaleCd(LocalDate saleUploadDt) {
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "WHM" + saleUploadDt.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-";
        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = whmoveRepository.getMaxWhmoveCd(saleUploadDt);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;
        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);
        return prefix + sequenceNumberString;
    }
    //[이벤트리스너_Sale]---------------------------------------------

    //[이벤트리스너_Input]---------------------------------------------
    public void addRowInput(InputEntity inputEntity) {
        WhmoveEntity whmoveEntity = new WhmoveEntity();
        String newWhmoveCd = generateNewInputCd(inputEntity.getInputPurDt());
        whmoveEntity.setWhmoveDt(inputEntity.getInputPurDt());
        whmoveEntity.setEmpInfoEntity(inputEntity.getOrinputEntity().getEmpInfoEntity());// 담당자(견적테이블 담당자)
        whmoveEntity.setItemEntity(inputEntity.getOrinputEntity().getItemEntity());//품목(견적테이블 품목)
        whmoveEntity.setWhregistEntity(inputEntity.getWhregistEntity());
        whmoveEntity.setWhmoveAmt(inputEntity.getOrinputEntity().getOrinputAmt());//수량(견적테이블 수량)
        whmoveEntity.setWhmoveGb("입고");
        whmoveEntity.setWhmoveCd(newWhmoveCd);
        whmoveRepository.save(whmoveEntity);
    }
    private String generateNewInputCd(LocalDate inputPurDt) {
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "WHM" + inputPurDt.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-";
        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = whmoveRepository.getMaxWhmoveCd(inputPurDt);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;
        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);
        return prefix + sequenceNumberString;
    }
    //[이벤트리스너_Input]---------------------------------------------

}
