package com.erpproject.sixbeam.st.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.repository.SaleRepository;
import com.erpproject.sixbeam.st.RowAddedEvent;
import com.erpproject.sixbeam.st.dto.AsDto;
import com.erpproject.sixbeam.st.dto.ReleaseDto;
import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.repository.AsRepository;
import com.erpproject.sixbeam.st.repository.ReleaseRepository;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReleaseService {

    private final ReleaseRepository releaseRepository;
    private final ApplicationEventPublisher event;
    private final ItemRepository itemRepository;
    private final AccountRepository accountRepository;
    private final EmpInfoRepository empInfoRepository;
    private final WhregistRepository whregistRepository;
    private  final SaleRepository saleRepository;

    public List<ReleaseEntity> getList() {
        return this.releaseRepository.findAll();
    }

    public ReleaseEntity getReleaseEntity(String releaseCd){
        Optional<ReleaseEntity> releaseEntity = this.releaseRepository.findById(releaseCd);
        if (releaseEntity.isPresent()){
            return releaseEntity.get();
        } else {
            throw new DataNotFoundException("releaseEntity not found");
        }
    }
    public void create(List<ReleaseDto> releaseDtos) {
        for (ReleaseDto releaseDto : releaseDtos) {
            String newReleaseCd = generateNewReleaseCd(releaseDtos.get(0).getReleaseDt());
            EmpInfoEntity empInfoEntity = empInfoRepository.findById(releaseDto.getEmpInfoEntity().getEmpInfoId())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            AccountEntity accountEntity = accountRepository.findById(releaseDto.getAccountEntity().getAccountCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            ItemEntity itemEntity = itemRepository.findById(releaseDto.getItemEntity().getItemCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            WhregistEntity whregistEntity = whregistRepository.findById(releaseDto.getWhregistEntity().getWhregistCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            SaleEntity saleEntity = saleRepository.findById(releaseDto.getSaleEntity().getSaleCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));

            releaseDto.setEmpInfoEntity(empInfoEntity);
            releaseDto.setAccountEntity(accountEntity);
            releaseDto.setItemEntity(itemEntity);
            releaseDto.setWhregistEntity(whregistEntity);
            releaseDto.setSaleEntity(saleEntity);
            ReleaseEntity releaseEntity = releaseDto.toEntity();

            releaseEntity.setReleaseCd(newReleaseCd);
            releaseRepository.save(releaseEntity);
            RowAddedEvent<ReleaseEntity> releaseEvent = new RowAddedEvent<>(this, releaseEntity);
            event.publishEvent(releaseEvent);
        }
    }

    private String generateNewReleaseCd(LocalDate releaseDate) {
        // 현재 날짜를 기반으로 새로운 주문 코드 생성
        String prefix = "REL" + releaseDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + "-";
        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = releaseRepository.getMaxReleaseCd(releaseDate);
        int sequenceNumber = maxCd != null ? Integer.parseInt(maxCd.substring(maxCd.lastIndexOf("-") + 1)) + 1 : 1;
        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);
        return prefix + sequenceNumberString;
    }
}
