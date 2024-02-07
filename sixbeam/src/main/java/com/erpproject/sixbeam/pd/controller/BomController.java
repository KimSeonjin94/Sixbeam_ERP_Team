package com.erpproject.sixbeam.pd.controller;


import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.BomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/pd/bom")
@Controller
@Slf4j
public class BomController {

    @Autowired
    private BomRepository bomRepository;

    @GetMapping("/bomlist")
    public String list(Model model) {

        // 1. 모든 데이터 가져오기
        List<BomEntity> bomEntities = bomRepository.findAll();

        // 2. 모델에 데이터 등록
        model.addAttribute("bomEntities", bomEntities);

        // 3. 모든 데이터 뷰페이지 반환
        return "contents/pd/bom_list";
    }

}
