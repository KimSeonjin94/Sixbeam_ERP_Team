package com.erpproject.sixbeam.st.service;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pur.dto.OrinPutDto;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.st.dto.WhregistDto;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void modalCreate(List<WhregistDto> whregistDtos) {
        for (WhregistDto whregistDto : whregistDtos) {
            WhregistEntity whregistEntity = whregistDto.toEntity();
            whregistRepository.save(whregistEntity);
        }
    }
    public List<WhregistEntity> getIdList(String id) {
        return this.whregistRepository.findByWhregistCd(id);
    }
}
