package com.erpproject.sixbeam.hr.service;

import com.erpproject.sixbeam.hr.entity.DepartEntity;
import com.erpproject.sixbeam.hr.repository.DepartRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartService {
    private final DepartRepository departRepository;

    public List<DepartEntity> getList() {
        return this.departRepository.findAll();
    }

    public void updateDepart(Long departCd, String departNm) {
        DepartEntity departEntity = departRepository.findById(departCd)
                .orElseThrow(() -> new RuntimeException("Depart with ID " + departNm + " not fount"));
        departEntity.setDepartCd(departCd);
        departEntity.setDepartNm(departNm);
        departRepository.save(departEntity);
    }

    public void createDepart(String departNm) {
        DepartEntity departEntity = new DepartEntity();
        departEntity.setDepartNm(departNm);
        departRepository.save(departEntity);
    }

    public void deleteDepart(List<Long> departCds) {
        for (Long departCd : departCds) {
            this.departRepository.deleteById(departCd);
        }
    }
}
