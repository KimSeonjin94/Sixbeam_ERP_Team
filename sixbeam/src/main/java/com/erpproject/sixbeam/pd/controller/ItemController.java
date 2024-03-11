package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.pd.dto.ItemDto;
import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.RitemEntity;
import com.erpproject.sixbeam.pd.service.BomService;
import com.erpproject.sixbeam.pd.service.FitemService;
import com.erpproject.sixbeam.pd.service.ItemService;
import com.erpproject.sixbeam.pd.service.RitemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/pd/item")
@Controller
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;
    private final FitemService fitemService;
    private final RitemService ritemService;
    private final BomService bomService;

    // 완품 조회
    @GetMapping("/itemlist")
    public String list(Model model) {

        // 서비스를 통해 모든 품목을 가져옴
        List<ItemEntity> itemEntities = itemService.getList();
        List<FitemEntity> fitemEntities = fitemService.getFitemList();
        List<RitemEntity> ritemEntities = ritemService.getRitemList();

        // 가져온 품목 리스트를 모델에 담음
        model.addAttribute("itemEntities", itemEntities);
        model.addAttribute("fitemEntities", fitemEntities);
        model.addAttribute("ritemEntities", ritemEntities);

        // 뷰페이지 반환
        return "bom_list";
    }

    // 품목 등록
    @PostMapping("/fcreate")
    public String createFitem(@ModelAttribute ItemDto itemDto, RedirectAttributes redirectAttributes) {

        try {
            itemService.saveFitem(itemDto);

        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/pd/finitem/finitemlist";
    }

    @PostMapping("/rcreate")
    public String createRitem(@ModelAttribute ItemDto itemDto, RedirectAttributes redirectAttributes) {

        try {
            itemService.saveRitem(itemDto);

        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/pd/rawitem/rawitemlist";
    }

    // 품목 수정
    @PostMapping("/update")
    public String editItem(@ModelAttribute ItemDto itemDto, RedirectAttributes redirectAttributes) {

        try {
            itemService.updateItem(itemDto);

        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/pd/bom/bomlist";
    }

    // 품목 삭제
    @PostMapping("/fdelete")
    public String deletefItem(@RequestParam("itemCd") List<String> itemCd) {

        itemService.deleteItem(itemCd);

        return "redirect:/pd/finitem/finitemlist";
    }

    @PostMapping("/rdelete")
    public String deleterItem(@RequestParam("itemCd") List<String> itemCd) {

        itemService.deleteItem(itemCd);

        return "redirect:/pd/rawitem/rawitemlist";
    }
}