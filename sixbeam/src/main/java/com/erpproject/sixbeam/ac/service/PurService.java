package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.entity.PurEntity;
import com.erpproject.sixbeam.ac.repository.PurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PurService {
    private final PurRepository purRepository;


}
