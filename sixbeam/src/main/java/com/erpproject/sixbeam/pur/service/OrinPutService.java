package com.erpproject.sixbeam.pur.service;

import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.repository.OrinPutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrinPutService {
    private final OrinPutRepository orinPutRepository;
    public List<OrinPutEntity> getList() {
        //return this.orinPutRepository.findAllByOrderByORINPUT_CDDesc();
        return this.orinPutRepository.findAll();
    }
}
