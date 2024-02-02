package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.pd.repository.RitemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pd/Ritem")
@Controller
@Slf4j
public class RitemController {

    @Autowired
    private RitemRepository ritemRepository;
}
