package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.SalesDto;
import com.erpproject.sixbeam.ac.entity.SalesEntity;
import com.erpproject.sixbeam.ac.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ac")
public class SalesController {

    @Autowired
    private SalesRepository salesRepository;


}
