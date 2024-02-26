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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        // 완품 리스트 뷰페이지 반환
        return "contents/pd/item_list";
    }

    /*@GetMapping("/ritemList/{itemCd}")
    public String ritemList(@PathVariable("itemCd") String itemCd, Model model) {
        List<RitemEntity> ritemEntities = ritemService.getRitemsByItemCd(itemCd);
        model.addAttribute("ritemEntities", ritemEntities);
        return "ritem_list"; // 이부분은 실제 뷰 페이지 이름으로 수정해주세요.
    }*/

    // 품목 등록
    @PostMapping("/create")
    public String createItem(@ModelAttribute ItemDto itemDto, RedirectAttributes redirectAttributes) {

        try {
            itemService.saveItem(itemDto);

        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/pd/item/itemlist";
    }

    // 품목 수정
    @PostMapping("/update")
    public String editItem(@ModelAttribute ItemDto itemDto, RedirectAttributes redirectAttributes) {

        try {
            itemService.updateItem(itemDto);

        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/pd/item/itemlist";
    }

    // 품목 삭제
    @PostMapping("/delete")
    public String deleteItem(@RequestParam("itemCd") List<String> itemCd) {

        itemService.deleteItem(itemCd);
        return "redirect:/pd/item/itemlist";
    }

    @PostMapping("/item/createform")
    public String registerItemByPage(@ModelAttribute ItemDto itemDto) {

        itemService.saveItem(itemDto);
        return "redirect:createform";
    }
}
