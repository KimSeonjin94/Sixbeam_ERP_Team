package com.erpproject.sixbeam.st.service;

import java.util.List;
import java.util.Optional;

import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import com.erpproject.sixbeam.st.repository.ReleaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReleaseService {

    private final ReleaseRepository releaseRepository;

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
}
