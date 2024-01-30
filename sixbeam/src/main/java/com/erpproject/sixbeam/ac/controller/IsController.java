package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.IsDto;
import com.erpproject.sixbeam.ac.entity.BsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ac")
public class IsController {
    @Autowired
    private IsRepository isRepository;

    @GetMapping
    public String createIsEntity(IsDto isDto) {
        BsEntity bsEntity = isDto.toEntity();

//        BsEntity saved = isRepository.save(isEntity);

        return "";
    }


}
