package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.BsDto;
import com.erpproject.sixbeam.ac.service.BsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BsController {

    private BsService bsService;

    @GetMapping
    @RequestBody
    public List<BsDto> () {
        return bsService.getAll();

    }
}
