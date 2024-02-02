package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.entity.ReceivablesEntity;
import com.erpproject.sixbeam.ac.repository.ReceivablesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReceivablesService {
    private final ReceivablesRepository receivablesRepository;

    public List<ReceivablesEntity> getList() {
        return this.receivablesRepository.findAll();
    }


}
