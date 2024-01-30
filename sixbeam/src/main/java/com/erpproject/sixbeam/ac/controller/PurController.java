package com.erpproject.sixbeam.ac.controller;

import com.erpproject.sixbeam.ac.dto.BsDto;
import com.erpproject.sixbeam.ac.entity.BsEntity;
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
    public String createBsEntity(BsDto bsDto) {
        BsEntity bsEntity = bsDto.toEntity();

//        BsEntity saved = bsRepository.save(bsEntity);

        return "";
    }
}
