package com.erpproject.sixbeam.pd.controller;


import com.erpproject.sixbeam.pd.dto.BomDto;
import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.BomRepository;
import com.erpproject.sixbeam.pd.service.BomService;
import com.erpproject.sixbeam.pur.dto.OrinPutDto;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/pd/bom")
@Controller
public class BomController {

    private final BomService bomService;

    // BOM 등록 페이지
    @GetMapping("/new")
    public String newBomDto(Model model) {
        model.addAttribute("bomDto", new BomDto());
        return "new_bom";
    }

    // BOM 등록 처리
    /*@PostMapping("/new")
    public String saveBom(@ModelAttribute BomDto bomDto) {

        // 저장된 BomDto를 BomEntity로 변환하여 BomService를 통해 저장
        bomService.saveBom(bomDto);

        // 저장 후 리스트 페이지로 이동
        return "redirect:/pd/bom/list";
    }*/

    @GetMapping("/bomlist")
    public String list(Model model) {

        // 1. 모든 데이터 가져오기
        List<BomEntity> bomEntities = bomService.getList();

        // 2. 모델에 데이터 등록
        model.addAttribute("bomEntities", bomEntities);

        // 3. 모든 데이터 뷰페이지 반환
        return "contents/pd/bom_list";
    }

    @PostMapping("/save")
    public String saveBomInput(@ModelAttribute BomDto bomDto) {
        BomEntity bomEntity = bomDto.toEntity();
        bomService.save(bomEntity);
        return "redirect:contents/pd/bom_list"; // 저장 후 목록 페이지로 리다이렉트
    }
}