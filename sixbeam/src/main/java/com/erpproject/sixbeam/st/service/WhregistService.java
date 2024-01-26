package com.erpproject.sixbeam.st.service;

import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WhregistService {

    private final WhregistRepository whregistRepository;

    public List<WhregistEntity> getList() {
        return this.whregistRepository.findAll();
    }
}
