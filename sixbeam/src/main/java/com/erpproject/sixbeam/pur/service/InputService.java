package com.erpproject.sixbeam.pur.service;

import com.erpproject.sixbeam.pur.dto.InputDto;

import com.erpproject.sixbeam.pur.entity.InputEntity;

import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.repository.InputRepository;
import com.erpproject.sixbeam.pur.repository.OrinPutRepository;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.event.WhmoveRowAddedEvent;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
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
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InputService {
    private final InputRepository inputRepository;
    private final OrinPutRepository orinPutRepository;
    private final WhregistRepository whregistRepository;
    private final ApplicationEventPublisher addEvent;
    private final ApplicationEventPublisher deleteEvent;
    private final ApplicationEventPublisher updateEvent;
    public List<InputEntity> getList() {
        return this.inputRepository.findAll();
    }

    public List<InputEntity> getIdList(String id) {

        return this.inputRepository.findByinputPurCd(id);
    }

    public void update(InputDto inputDto) {
        if(inputDto.isInputSiFl()){
            throw new IllegalStateException("회계 반영되어 수정 불가 합니다.");
        }

        List<OrinPutEntity> orinPutEntity = orinPutRepository.findByOrinputCd(inputDto.getOrinputEntity().getOrinputCd());
        if (orinPutEntity == null) {
            throw new EntityNotFoundException("발주 코드를 찾을 수 없습니다.");
        }


        WhregistEntity whregistEntity = whregistRepository.findById(inputDto.getWhregistEntity().getWhregistCd())
                .orElseThrow(() -> new EntityNotFoundException("창고 코드를 찾을 수 없습니다."));

        InputEntity inputEntity = inputDto.toEntity();

        //저장할때는 구매코드를 새로 만들기 때문에 toEntity함수에 넣지 않아 수정할때는 따로 set 필요
        inputEntity.setInputPurCd(inputDto.getInputPurCd());

        inputEntity.setOrinputEntity(orinPutEntity.get(0));
        inputEntity.setWhregistEntity(whregistEntity);

        inputRepository.save(inputEntity);
        WhmoveRowUpdatedEvent<InputEntity> inputEvent = new WhmoveRowUpdatedEvent<>(this, inputEntity);
        updateEvent.publishEvent(inputEvent);//이벤트리스너
    }
    
    public void save(InputDto inputDto) {
        //구매 테이블에서 저장된 발주코드가 있는지 확인하여 있으면 이미 저장이 되어 있으므로 동일한 발주코드로 저장안되게 함
        boolean isReferenced = inputRepository.existsByOrinputEntity_OrinputCd(inputDto.getOrinputEntity().getOrinputCd());
        if (isReferenced) {
            throw new IllegalStateException("동일한 발주 코드 진행 이력이 있어 저장이 불가 합니다.");
        }

        OrinPutEntity orinPutEntity = orinPutRepository.findById(inputDto.getOrinputEntity().getOrinputCd()).
                orElseThrow(() -> new EntityNotFoundException("발주 코드를 찾을 수 없습니다."));

        WhregistEntity whregistEntity = whregistRepository.findById(inputDto.getWhregistEntity().getWhregistCd())
                .orElseThrow(() -> new EntityNotFoundException("창고 코드를 찾을 수 없습니다."));

        InputEntity inputEntity = inputDto.toEntity();
        String newInputCd = generateNewInputCd(inputDto.getInputPurDt());
        inputEntity.setInputPurCd(newInputCd);
        inputEntity.setOrinputEntity(orinPutEntity);
        inputEntity.setWhregistEntity(whregistEntity);
        inputRepository.save(inputEntity);
        WhmoveRowAddedEvent<InputEntity> inputEvent = new WhmoveRowAddedEvent<>(this, inputEntity);
        addEvent.publishEvent(inputEvent);//[이벤트리스너]
    }
    private String generateNewInputCd(LocalDate inputDate) {
        // 현재 날짜를 기반으로 새로운 구매 코드 생성
        String prefix = "PUR" + inputDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-";

        // DB에서 최대 구매 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = inputRepository.getMaxInputCd(inputDate);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;

        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);

        return prefix + sequenceNumberString;
    }

    @Transactional
    public void delete(List<String> inputIds) {
        List<InputEntity> inputEntitiesToDelete = new ArrayList<>();//이벤트리스너_삭제를 위한 추가코드
        for (String inputId : inputIds) {
            // 구매 삭제시 회계반영이 되었는지 확인 후 반영이 되어있으면 삭제 불가
            boolean isReferenced = inputRepository.checkInputSiFl(inputId);
            if (isReferenced) {
                throw new IllegalStateException("회계 반영되어 삭제 불가 합니다.");
            } else {
                List<InputEntity> inPutEntities = inputRepository.findByinputPurCd(inputId);
                inputEntitiesToDelete.addAll(inPutEntities);//이벤트리스너_삭제를 위한 추가코드
                inputRepository.deleteAll(inPutEntities);
            }
        }
        WhmoveRowDeletedEvent<InputEntity> inputDeletedEvent = new WhmoveRowDeletedEvent<>(this, inputEntitiesToDelete);
        deleteEvent.publishEvent(inputDeletedEvent);
    }

    @Transactional
    public void updateInputEntity(String inputPurCd) {
        List<InputEntity> inputEntityList = inputRepository.findByinputPurCd(inputPurCd);

        for(InputEntity inputEntity : inputEntityList) {
            OrinPutEntity orinPutEntity = inputEntity.getOrinputEntity();
            orinPutEntity.setOrinputEtc("구매완료");
            inputRepository.save(inputEntity);
        }
    }
}
