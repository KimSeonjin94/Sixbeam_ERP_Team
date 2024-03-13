package com.erpproject.sixbeam.st.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.ss.SsRowAddEvent;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.repository.SaleRepository;
import com.erpproject.sixbeam.st.dto.ReleaseDto;
import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import com.erpproject.sixbeam.st.repository.ReleaseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReleaseService {

    private final ReleaseRepository releaseRepository;
    private final EmpInfoRepository empInfoRepository;
    private final SaleRepository saleRepository;
    private final ApplicationEventPublisher addRowEvent;

    public List<ReleaseEntity> getList() {
        return this.releaseRepository.findAll();
    }

    public List<ReleaseEntity> getIdList(String id) {
        return this.releaseRepository.findByReleaseCd(id);
    }

    public ReleaseEntity getReleaseEntity(String releaseCd) {
        Optional<ReleaseEntity> releaseEntity = this.releaseRepository.findById(releaseCd);
        if (releaseEntity.isPresent()) {
            return releaseEntity.get();
        } else {
            throw new DataNotFoundException("releaseEntity not found");
        }
    }

    public void create(ReleaseDto releaseDto) {

        String newReleaseCd = generateNewReleaseCd(releaseDto.getReleaseDt());
        EmpInfoEntity empInfoEntity = empInfoRepository.findById(releaseDto.getEmpInfoEntity().getEmpInfoId())
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));
        SaleEntity saleEntity = saleRepository.findById(releaseDto.getSaleEntity().getSaleCd())
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));
        releaseDto.setEmpInfoEntity(empInfoEntity);
        releaseDto.setSaleEntity(saleEntity);
        ReleaseEntity releaseEntity = releaseDto.toEntity();
        releaseEntity.setReleaseCd(newReleaseCd);
        releaseRepository.save(releaseEntity);
        SsRowAddEvent<ReleaseEntity> saleEntitySsRowAddEvent = new SsRowAddEvent<>(this,releaseEntity);
        addRowEvent.publishEvent(saleEntitySsRowAddEvent);
    }

    public void updateAll(ReleaseDto releaseDto) {
        EmpInfoEntity empInfoEntity = empInfoRepository.findById(releaseDto.getEmpInfoEntity().getEmpInfoId())
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));
        SaleEntity saleEntity = saleRepository.findById(releaseDto.getSaleEntity().getSaleCd())
                .orElseThrow(() -> new EntityNotFoundException("Item not found"));
        releaseDto.setEmpInfoEntity(empInfoEntity);
        releaseDto.setSaleEntity(saleEntity);
        ReleaseEntity releaseEntity = releaseDto.toEntity();
        releaseRepository.save(releaseEntity);
    }

    @Transactional
    public void delete(List<String> releaseDtos) {
        for (String releaseCd : releaseDtos) {
            List<ReleaseEntity> releaseEntities = releaseRepository.findByReleaseCd(releaseCd);
            releaseRepository.deleteAll(releaseEntities);
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
