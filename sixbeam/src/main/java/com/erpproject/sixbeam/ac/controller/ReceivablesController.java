package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.ReceivablesDto;
import com.erpproject.sixbeam.ac.entity.ReceivablesEntity;
import com.erpproject.sixbeam.ac.repository.ReceivablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ac")
public class ReceivablesController {

    @Autowired
    private ReceivablesRepository receivablesRepository;

    @GetMapping("/receivables")
    public String createReceivablesEntity(ReceivablesDto receivablesDto) {
        ReceivablesEntity receivablesEntity = receivablesDto.toEntity();

//        ReceivablesEntity saved = receivablesRepository.save(receivablesEntity);

        return "";
    }
}
