package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.PurDto;
import com.erpproject.sixbeam.ac.entity.PurEntity;
import com.erpproject.sixbeam.ac.repository.PurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ac")
public class PurController {

    @Autowired
    private PurRepository purRepository;

    @GetMapping
    public String createPurEntity(PurDto purDto) {
        PurEntity purEntity = purDto.toEntity();

        PurEntity saved = purRepository.save(purEntity);

        return "";
    }
}
