package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.entity.PayablesEntity;
import com.erpproject.sixbeam.ac.repository.PayablesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PayablesService {
    private final PayablesRepository payablesRepository;

    public List<PayablesEntity> getList() {
        return this.payablesRepository.findAll();}

}
