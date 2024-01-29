package com.erpproject.sixbeam.pd.controller;


import com.erpproject.sixbeam.pd.entity.EmpInfoEntity;
import com.erpproject.sixbeam.pd.repository.PdInfoRepository;
import com.erpproject.sixbeam.pd.service.EmpInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/pd")
@Controller
@Slf4j
public class EmpInfoController {

    @Autowired
    private PdInfoRepository pdInfoRepository;

}
