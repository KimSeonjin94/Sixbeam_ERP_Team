package com.erpproject.sixbeam.pur.service;

import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.pur.repository.InputRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InputService {
    private final InputRepository inputRepository;
    public List<InputEntity> getList() {
        return this.inputRepository.findAll();
    }
}
