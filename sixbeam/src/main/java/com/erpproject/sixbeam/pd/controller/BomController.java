package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.pd.Form.BomForm;
import com.erpproject.sixbeam.pd.Form.OrderForm;
import com.erpproject.sixbeam.pd.dto.BomDto;
import com.erpproject.sixbeam.pd.dto.OrderDto;
import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.RitemEntity;
import com.erpproject.sixbeam.pd.service.BomService;
import com.erpproject.sixbeam.pd.service.FitemService;
import com.erpproject.sixbeam.pd.service.ItemService;
import com.erpproject.sixbeam.pd.service.RitemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/pd/bom")
@Controller
public class BomController {

    private final BomService bomService;
    private final RitemService ritemService;
    private final FitemService fitemService;
    private final ItemService itemService;

    // BOM 데이터 등록 페이지
    @GetMapping("/new")
    public String newBomDto(Model model) {

        BomForm bomForm = new BomForm();
        List<RitemEntity> ritemEntities = ritemService.getRitemList();

        // 등록창 한 줄
        bomForm.getBomDtos().add(new BomDto());

        model.addAttribute("getRitemList", ritemEntities);
        model.addAttribute("bomForm", bomForm);


        bomService.readyBomForm(model);
        return "/contents/pd/bom_form";
    }

    // 새 bom 작성
    @PostMapping("/create")
    public ResponseEntity<?> createOrderDto(@ModelAttribute BomForm bomForm) {

        List<BomDto> bomDtos = bomForm.getBomDtos();

        try {
            bomService.create(bomDtos);

            return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/pd/rawitem/rawitemlist"));

        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/pd/rawitem/rawitemlist");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/fcreate")
    public ResponseEntity<?> createFitemOrderDto(@ModelAttribute BomForm bomForm) {

        List<BomDto> bomDtos = bomForm.getBomDtos();

        try {
            bomService.create(bomDtos);

            return ResponseEntity.ok().body(Collections.singletonMap("redirectUrl", "/pd/finitem/finitemlist"));

        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "저장에 실패 하였습니다.");
            errorResponse.put("redirectUrl", "/pd/bom/new");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    // bom 리스트 출력
    @GetMapping("/bomlist")
    public String list(Model model) {

        /*bomService.getBomList(model);
        return "/contents/pd/bom_list";*/

        // 서비스를 통해 모든 품목을 가져옴
        List<ItemEntity> itemEntities = itemService.getList();
        List<FitemEntity> fitemEntities = fitemService.getFitemList();
        List<RitemEntity> ritemEntities = ritemService.getRitemList();

        // 가져온 품목 리스트를 모델에 담음
        model.addAttribute("itemEntities", itemEntities);
        model.addAttribute("fitemEntities", fitemEntities);
        model.addAttribute("ritemEntities", ritemEntities);

        // 완품 리스트 뷰페이지 반환
        return "/contents/pd/bom_list";
    }

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