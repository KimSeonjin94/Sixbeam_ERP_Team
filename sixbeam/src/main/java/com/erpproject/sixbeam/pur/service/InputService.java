package com.erpproject.sixbeam.pur.service;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pur.dto.InputDto;

import com.erpproject.sixbeam.pur.entity.InputEntity;

import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.entity.OrinPutEntityId;
import com.erpproject.sixbeam.pur.repository.InputRepository;
import com.erpproject.sixbeam.pur.repository.OrinPutRepository;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class InputService {
    private final InputRepository inputRepository;
    private final OrinPutRepository orinPutRepository;
    private final WhregistRepository whregistRepository;
    public List<InputEntity> getList() {
        return this.inputRepository.findAll();
    }

    public List<InputEntity> getIdList(String id) {

        return this.inputRepository.findByinputPurCd(id);
    }
    public void update(InputDto inputDto) {
        List<OrinPutEntity> orinputEntity = orinPutRepository.findByOrinputCd(inputDto.getOrinputEntity().getOrinputCd());


        WhregistEntity whregistEntity = whregistRepository.findById(inputDto.getWhregistEntity().getWhregistCd())
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));

        InputEntity inputEntity = inputDto.toEntity();

        String newInputCd = generateNewInputCd(inputDto.getInputPurDt());
        inputEntity.setOrinputEntity(orinputEntity.get(0));
        inputEntity.setWhregistEntity(whregistEntity);

        inputRepository.save(inputEntity);
    }

    public void save(InputDto inputDto) {
          List<OrinPutEntity> orinputEntity = orinPutRepository.findByOrinputCd(inputDto.getOrinputEntity().getOrinputCd());
//
//        WhregistEntity whregistEntity = whregistRepository.findById(inputDto.getWhregistEntity().getWhregistCd())
//                .orElseThrow(() -> new EntityNotFoundException("Item not found"));
//
//        InputEntity inputEntity = inputDto.toEntity();
//
//        String newInputCd = generateNewInputCd(inputDto.getInputPurDt());
//        inputEntity.setInputPurCd(newInputCd);
//        inputEntity.setOrinputEntity(orinputEntity.get(0));
//        inputEntity.setWhregistEntity(whregistEntity);
//
//        inputRepository.save(inputEntity);

        // OrinPutEntityId 인스턴스 생성
        String orinputCd = inputDto.getOrinputEntity().getOrinputCd();
        inputDto.setOrinputEntity(orinputEntity.get(0));
        ItemEntity itemEntity = inputDto.getOrinputEntity().getItemEntity();

        // OrinPutEntity 조회
        OrinPutEntity orinPutEntity = orinPutRepository.findByOrinputCdAndItemEntity(orinputCd, itemEntity);
        if (orinPutEntity == null) {
            // 복합 기본 키에 해당하는 엔티티가 없는 경우 처리
            // 예를 들어 예외를 던지거나 새로운 엔티티를 생성할 수 있음
            throw new EntityNotFoundException("OrinPutEntity not found for orinputCd: " + orinputCd + " and itemEntity: " + itemEntity);
        }

        // WhregistEntity 조회
        WhregistEntity whregistEntity = whregistRepository.findById(inputDto.getWhregistEntity().getWhregistCd())
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));

        // InputEntity 생성 및 저장
        InputEntity inputEntity = inputDto.toEntity();
        String newInputCd = generateNewInputCd(inputDto.getInputPurDt());
        inputEntity.setInputPurCd(newInputCd);
        inputEntity.setOrinputEntity(orinPutEntity);
        inputEntity.setWhregistEntity(whregistEntity);
        inputRepository.save(inputEntity);
    }
    private String generateNewInputCd(LocalDate inputDate) {
        // 현재 날짜를 기반으로 새로운 구매 코드 생성
        String prefix = "PUR" + inputDate.format(DateTimeFormatter.ofPattern("yyMMdd")) + "-";

        // DB에서 최대 구매 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = inputRepository.getMaxInputCd(inputDate);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;

        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);

        return prefix + sequenceNumberString;
    }

    @Transactional
    public void delete(List<String> inputIds) {
        for (String inputId : inputIds) {
            // 구매 삭제시 회계반영이 되었는지 확인 후 반영이 되어있으면 삭제 불가
            boolean isReferenced = inputRepository.checkInputSiFl(inputId);
            if (isReferenced) {
                // ORINPUT_CD를 참조하는 엔티티가 존재하면 삭제를 거부
                throw new IllegalStateException("회계 반영되어 삭제 불가 합니다.");
            } else {
                // ORINPUT_CD를 참조하는 엔티티가 없으면 삭제를 진행
                List<InputEntity> inPutEntities = inputRepository.findByinputPurCd(inputId);
                inputRepository.deleteAll(inPutEntities);
            }
        }
    }
}
