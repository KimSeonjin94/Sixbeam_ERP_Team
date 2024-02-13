package com.erpproject.sixbeam.hr.service;

import com.erpproject.sixbeam.hr.entity.PositionEntity;
import com.erpproject.sixbeam.hr.repository.PositionRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;
    public List<PositionEntity> getList() {
        return this.positionRepository.findAll();
    }
    public void updatePosition(Long positionCd,String positionNm){
        PositionEntity positionEntity = positionRepository.findById(positionCd)
                .orElseThrow(() -> new RuntimeException("position with ID "+ positionNm + " not fount"));
        positionEntity.setPositionCd(positionCd);
        positionEntity.setPositionNm(positionNm);
        positionRepository.save(positionEntity);
    }
    public void createPosition(String positionNm){
        PositionEntity positionEntity = new PositionEntity();
        positionEntity.setPositionNm(positionNm);
        positionRepository.save(positionEntity);
    }
    public void deletePosition(Long positionCd){
        this.positionRepository.deleteById(positionCd);
    }
}

