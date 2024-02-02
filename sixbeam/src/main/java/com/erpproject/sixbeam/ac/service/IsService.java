package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.entity.IsEntity;
import com.erpproject.sixbeam.ac.repository.IsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IsService {
    private final IsRepository isRepository;

    public List<IsEntity> getList() {
        return this.isRepository.findAll();
    }

}
