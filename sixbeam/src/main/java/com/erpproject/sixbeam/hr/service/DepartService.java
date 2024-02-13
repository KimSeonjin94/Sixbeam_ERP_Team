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
}
