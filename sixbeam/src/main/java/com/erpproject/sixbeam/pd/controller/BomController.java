package com.erpproject.sixbeam.pd.controller;


import com.erpproject.sixbeam.pd.Form.BomForm;
import com.erpproject.sixbeam.pd.dto.BomDto;
import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.service.BomService;
import com.erpproject.sixbeam.pd.service.ItemService;
import com.erpproject.sixbeam.ss.form.EstimateForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        BomForm bomForm = new BomForm();

        List<ItemEntity> cpus = this.itemService.getCPU();
        List<ItemEntity> mbs = this.itemService.getMB();
        List<ItemEntity> vgas = this.itemService.getVGA();
        List<ItemEntity> rams = this.itemService.getRAM();
        List<ItemEntity> ssds = this.itemService.getSSD();
        List<ItemEntity> hdds = this.itemService.getHDD();
        List<ItemEntity> powers = this.itemService.getPOWER();
        List<ItemEntity> cases = this.itemService.getCASE();

        // 빈 BomDto를 생성하여 모델에 추가
        model.addAttribute("cpu", cpus);
        model.addAttribute("MB", mbs);
        model.addAttribute("vga", vgas);
        model.addAttribute("ram", rams);
        model.addAttribute("ssd", ssds);
        model.addAttribute("hdd", hdds);
        model.addAttribute("power", powers);
        model.addAttribute("case", cases);
        model.addAttribute("bomForm", bomForm);

        // 새로운 폼 생성(폼 페이지의 한 행)
        bomForm.getBomDtos().add(new BomDto());

        // 저장 후 목록 페이지로 리다이렉트
        return "/contents/pd/bom_form";
    }

    @PostMapping("/create")
    public String createBomDto(@ModelAttribute BomForm bomForm) {

        List<BomDto> bomDtos = bomForm.getBomDtos();

        this.bomService.create(bomDtos);

        return "redirect:/pd/bom/bomlist";
    }

    @GetMapping("/bomlist")
    public String list(Model model) {

        BomForm bomForm = new BomForm();

        // 데이터 가져오기
        List<BomEntity> getbomEntity = bomService.getList();
        List<ItemEntity> getitemEntity = this.itemService.getList();

        // form 데이터 입력란 추가
        bomForm.getBomDtos().add(new BomDto());

        // 모델에 데이터 등록
        model.addAttribute("bomlist", getbomEntity);
        model.addAttribute("getitemlist", getitemEntity);

        // 모든 데이터 뷰페이지 반환
        return "contents/pd/bom_list";
    }

    /*@GetMapping("/list/detail/{id}")
    public String detail(Model model, @PathVariable("id") String itemCd) {
        List<BomEntity> bomEntities =
    }*/
}