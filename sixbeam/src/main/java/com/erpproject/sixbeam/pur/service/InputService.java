package com.erpproject.sixbeam.pur.service;

import com.erpproject.sixbeam.pur.dto.InputDto;

import com.erpproject.sixbeam.pur.entity.InputEntity;

import com.erpproject.sixbeam.pur.repository.InputRepository;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InputService {
    private final InputRepository inputRepository;
    private final WhregistRepository whregistRepository;
    public List<InputEntity> getList() {
        return this.inputRepository.findAll();
    }

    public void save(List<InputDto> inputDtos) {
        for (InputDto inputDto : inputDtos) {
            WhregistEntity whregistEntity = whregistRepository.findById(inputDto.getWhregistEntity().getWhregistCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            InputEntity inputEntity = inputDto.toEntity();
            String newInputCd = generateNewInputCd(inputDto.getInputPurDt());
            inputEntity.setInputPurCd(newInputCd);
            inputRepository.save(inputEntity);
        }
    }
    private String generateNewInputCd(LocalDate inputDate) {
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "PUR" + inputDate.format(DateTimeFormatter.ofPattern("yyMMdd")) + "-";

        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = inputRepository.getMaxInputCd(inputDate);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;

        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);

        return prefix + sequenceNumberString;
    }
}
