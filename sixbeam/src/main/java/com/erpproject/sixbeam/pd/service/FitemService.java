package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.pd.repository.FitemRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FitemService {

    private final FitemService fitemService;

    public FitemService(FitemService fitemService) {
        this.fitemService = fitemService;
    }
}
