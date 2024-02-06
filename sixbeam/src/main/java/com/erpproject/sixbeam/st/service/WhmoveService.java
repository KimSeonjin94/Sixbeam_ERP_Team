package com.erpproject.sixbeam.st.service;

import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.repository.WhmoveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WhmoveService {

    private final WhmoveRepository whmoveRepository;

    public List<WhmoveEntity> getList() {
        return this.whmoveRepository.findAll();
    }
    public WhmoveEntity getWhmoveEntity(String whmoveCd){
        Optional<WhmoveEntity> whmoveEntity = this.whmoveRepository.findById(whmoveCd);
        if (whmoveEntity.isPresent()){
            return whmoveEntity.get();
        } else {
            throw new DataNotFoundException("whmoveEntity not found");
        }
    }
}
