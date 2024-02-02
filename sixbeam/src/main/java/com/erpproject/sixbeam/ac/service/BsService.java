package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.entity.BsEntity;
import com.erpproject.sixbeam.ac.repository.BsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BsService {
    private final BsRepository bsRepository;

    public List<BsEntity> getList() {
        return this.bsRepository.findAll();
    }
}
