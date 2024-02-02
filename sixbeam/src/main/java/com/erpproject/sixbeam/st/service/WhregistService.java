package com.erpproject.sixbeam.st.service;

import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
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

    public  WhregistEntity getWhregistEntity(String whRegistCd){
        Optional<WhregistEntity> whregistEntity = this.whregistRepository.findById(whRegistCd);
        if (whregistEntity.isPresent()){
            return whregistEntity.get();
        } else {
            throw new DataNotFoundException("whregistEntity not found");
        }
    }
}
