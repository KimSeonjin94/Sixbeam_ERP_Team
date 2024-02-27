package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.pd.Form.BomForm;
import com.erpproject.sixbeam.pd.dto.BomDto;
import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.RitemEntity;
import com.erpproject.sixbeam.pd.service.BomService;
import com.erpproject.sixbeam.pd.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/pd/bom")
@Controller
public class BomController {

    private final BomService bomService;

    // BOM 데이터 등록 페이지
    @GetMapping("/new")
    public String newBomDto(Model model) {

        bomService.readyBomForm(model);
        return "/contents/pd/bom_form";
    }

    // 새 bom 작성
    @PostMapping("/create")
    public ResponseEntity<?> createBomDto(@ModelAttribute BomForm bomForm) {

        return bomService.createBomDto(bomForm);
    }

    // bom 리스트 출력
    @GetMapping("/bomlist")
    public String list(Model model) {

        bomService.getBomList(model);
        return "contents/pd/bom_list";
    }

    // id로 리스트 조회
    /*@GetMapping("/list/detail/{id}")
    public ResponseEntity<List<BomEntity>> detail(@PathVariable("id") String itemCd) {

        return bomService.getBomDetails(itemCd);
    }*/

    @GetMapping("/detail/{itemCd}")
    public ResponseEntity<List<BomEntity>> detail(@PathVariable("itemCd") String fitemCd) {

        List<BomEntity> bomEntities = bomService.getRitemsByItemCd(fitemCd);
        if (!bomEntities.isEmpty()) {

            return ResponseEntity.ok().body(bomEntities);

        } else {

            return ResponseEntity.notFound().build();
        }
    }

    // 수정
    @PostMapping("/update")
    public String updateBom(@ModelAttribute BomForm bomForm) {

        bomService.updateBomList(bomForm);
        return "redirect:/pd/bom/bomlist";
    }
}