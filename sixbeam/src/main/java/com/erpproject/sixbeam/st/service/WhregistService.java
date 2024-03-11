package com.erpproject.sixbeam.st.service;


import com.erpproject.sixbeam.st.dto.WhregistDto;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WhregistService {

    private final WhregistRepository whregistRepository;

    public List<WhregistEntity> getList() {
        return this.whregistRepository.findAll();
    }

    public  WhregistEntity getWhregistEntity(String whregistCd){
        Optional<WhregistEntity> whregistEntity = this.whregistRepository.findById(whregistCd);
        if (whregistEntity.isPresent()){
            return whregistEntity.get();
        } else {
            throw new DataNotFoundException("whregistEntity not found");
        }
    }

    public void pageCreate(String whregistCd, String whregistNm) {
        WhregistEntity w = new WhregistEntity();
        w.setWhregistCd(whregistCd);
        w.setWhregistNm(whregistNm);
        this.whregistRepository.save(w);
    }

    public void create(List<WhregistDto> whregistDtos) {
        for (WhregistDto whregistDto : whregistDtos) {
            String newWhregistCd = generateNewWhregistCd();
            WhregistEntity whregistEntity = whregistDto.toEntity();
            whregistEntity.setWhregistCd(newWhregistCd);
            whregistRepository.save(whregistEntity);
        }
    }
    public List<WhregistEntity> getIdList(String id) {
        return this.whregistRepository.findByWhregistCd(id);
    }

    public void updateAll(WhregistDto whregistDto) {
        WhregistEntity whregistEntity = whregistDto.toEntity();
        whregistRepository.save(whregistEntity);
    }
    @Transactional
    public void delete(List<String> whregistDtos) {
        for (String whregistCd : whregistDtos) {
            List<WhregistEntity> whregistEntities = whregistRepository.findByWhregistCd(whregistCd);
            whregistRepository.deleteAll(whregistEntities);
        }
    }
    private String generateNewWhregistCd() {
        String prefix = "WHR";
        // DB에서 최대 주문 코드를 가져와서 숫자 부분 추출 후 +1 증가
        String maxCd = whregistRepository.getMaxWhregistCd();
        int sequenceNumber =Integer.parseInt(maxCd.substring(maxCd.indexOf('R') + 1)) + 1;
        // 4자리 숫자 부분을 형식에 맞게 생성
        String sequenceNumberString = String.format("%04d", sequenceNumber);
        return prefix + sequenceNumberString;
    }
}

