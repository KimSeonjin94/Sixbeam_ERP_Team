package com.erpproject.sixbeam.st.service;

import com.erpproject.sixbeam.st.entity.AsEntity;
import com.erpproject.sixbeam.st.repository.AsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AsService {

    private final AsRepository asRepository;

    public List<AsEntity> getList() {
        return this.asRepository.findAll();
    }

    public AsEntity getAsEntity(String asCd) {
        Optional<AsEntity> asEntity = this.asRepository.findById(asCd);
        if (asEntity.isPresent()) {
            return asEntity.get();
        } else {
            throw new DataNotFoundException("asEntity not found");
        }
    }
}
