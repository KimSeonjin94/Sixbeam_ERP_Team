package com.erpproject.sixbeam.pd.controller;


import com.erpproject.sixbeam.pd.dto.BomDto;
import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.service.BomService;
import com.erpproject.sixbeam.pd.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/pd/bom")
@Controller
public class BomController {

    private final BomService bomService;
    private final ItemService itemService;

    // BOM 등록 페이지
    @GetMapping("/new")
    public String newBomDto(Model model) {

        List<ItemEntity> cpus = itemService.getCPU();
        model.addAttribute("cpu", cpus);

        List<ItemEntity> mbs = itemService.getMB();
        model.addAttribute("MB", mbs);

        List<ItemEntity> vgas = itemService.getVGA();
        model.addAttribute("vga", vgas);

        List<ItemEntity> rams = itemService.getRAM();
        model.addAttribute("ram", rams);

        List<ItemEntity> ssds = itemService.getSSD();
        model.addAttribute("ssd", ssds);

        List<ItemEntity> hdds = itemService.getHDD();
        model.addAttribute("hdd", hdds);

        List<ItemEntity> powers = itemService.getPOWER();
        model.addAttribute("power", powers);

        List<ItemEntity> cases = itemService.getCASE();
        model.addAttribute("case", cases);

        // 빈 BomDto를 생성하여 모델에 추가
        model.addAttribute("bomDto", new BomDto());

        // 저장 후 목록 페이지로 리다이렉트
        return "redirect:contents/pd/bom_list";
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
        List<ItemEntity> itemEntity = this.itemService.getList();

        // 2. 모델에 데이터 등록
        model.addAttribute("bomEntities", bomEntities);
        model.addAttribute("getitemlist", itemEntity);

        // 3. 모든 데이터 뷰페이지 반환
        return "contents/pd/bom_list";
    }

    /*@PostMapping("/save")
    public String saveBomInput(@ModelAttribute BomDto bomDto) {
        BomEntity bomEntity = bomDto.toEntity();
        bomService.save(bomEntity);
        return "redirect:contents/pd/bom_list"; // 저장 후 목록 페이지로 리다이렉트
    }*/
}