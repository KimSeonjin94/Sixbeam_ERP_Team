package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.PayablesDto;
import com.erpproject.sixbeam.ac.entity.PayablesEntity;
import com.erpproject.sixbeam.ac.repository.PayablesRepository;
import com.erpproject.sixbeam.ac.repository.PurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ac")
public class PayablesController {

    @Autowired
    private PayablesRepository payablesRepository;



}
