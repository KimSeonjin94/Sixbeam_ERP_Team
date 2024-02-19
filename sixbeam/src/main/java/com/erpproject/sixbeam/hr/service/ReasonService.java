package com.erpproject.sixbeam.hr.service;


import com.erpproject.sixbeam.hr.entity.ReasonEntity;
import com.erpproject.sixbeam.hr.repository.ReasonRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReasonService {
    private final ReasonRepository reasonRepository;
    public List<ReasonEntity> getList() {
        return this.reasonRepository.findAll();
    }
    public void updateReason(Long reasonCd,String reasonNm){
        ReasonEntity reasonEntity = reasonRepository.findById(reasonCd)
                .orElseThrow(() -> new RuntimeException("reason with ID "+ reasonNm + " not fount"));
        reasonEntity.setReasonCd(reasonCd);
        reasonEntity.setReasonNm(reasonNm);
        reasonRepository.save(reasonEntity);
    }
    public void createReason(String reasonNm){
        ReasonEntity reasonEntity = new ReasonEntity();
        reasonEntity.setReasonNm(reasonNm);
        reasonRepository.save(reasonEntity);
    }
    public void deleteReason(List<Long> reasonCds) {
        for (Long reasonCd : reasonCds) {
            this.reasonRepository.deleteById(reasonCd);
        }
    }
}

