package com.erpproject.sixbeam.pd.controller;


import com.erpproject.sixbeam.pd.repository.BomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/pd/Bom")
@Controller
@Slf4j
public class BomController {

    @Autowired
    private BomRepository bomRepository;

}
