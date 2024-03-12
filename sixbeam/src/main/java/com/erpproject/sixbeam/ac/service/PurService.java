package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.dto.PurDto;
import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.entity.PurEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import com.erpproject.sixbeam.ac.repository.PurRepository;
import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.pur.repository.InputRepository;
import com.erpproject.sixbeam.pur.service.InputService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class PurService {
    private final PurRepository purRepository;
    private final InputRepository inputRepository;
    private final AccountRepository accountRepository;
    private final InputService inputService;

    PurEntity purEntity;
    public List<InputEntity> getInputList(){
        return this.inputRepository.findByInputSiFl(false);
    }

    public void savePurSLip(PurDto purDto) {
        purEntity = purDto.toEntity();
        // 매개변수로 받은 accountDto를 엔티티로 변환하여 대입
        AccountEntity accountEntity = accountRepository.findById(purDto.getAccountEntity().getAccountCd())
                .orElseThrow(() -> new EntityNotFoundException("거래처 코드를 찾을 수 없습니다."));

        InputEntity inputEntity = inputRepository.findById(purDto.getInputEntity().getInputPurCd())
                .orElseThrow(() -> new EntityNotFoundException("구매 코드를 찾을 수 없습니다."));

        purEntity.setAccountEntity(accountEntity);
        purEntity.setInputEntity(inputEntity);

        inputRepository.updateInput(LocalDate.now(),purDto.getInputEntity().getInputPurCd());
        inputService.updateInputEntity(purDto.getInputEntity().getInputPurCd());

        purRepository.save(purEntity);

        // 변환된 accountEntity를 레포지토리에 저장한다.
    }


}
