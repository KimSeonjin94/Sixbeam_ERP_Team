package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.ac.dto.AccountDto;
import com.erpproject.sixbeam.pd.Form.BomForm;
import com.erpproject.sixbeam.pd.Form.ItemForm;
import com.erpproject.sixbeam.pd.dto.BomDto;
import com.erpproject.sixbeam.pd.dto.ItemDto;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pd/item")
@Controller
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;
    // 품목 전체 조회
    @GetMapping("/itemlist")
    public String list(Model model) {
        // 서비스를 통해 모든 품목을 가져옴
        List<ItemEntity> itemEntities = itemService.getList();
        // 가져온 품목 리스트를 모델에 담음
        model.addAttribute("itemEntities", itemEntities);
        // 품목 리스트 뷰페이지 반환
        return "contents/pd/item_list";
    }
    // 품목 신규
    @PostMapping("/create")
    public String createItem(@ModelAttribute ItemDto itemDto) {
        itemService.saveItem(itemDto);
        return "redirect:/pd/item/itemlist";
    }
    // 품목 수정
    @PostMapping("/update")
    public String editItem(@ModelAttribute ItemDto itemDto) {

        itemService.updateItem(itemDto);
        return "redirect:/pd/item/itemlist";
    }
    // 품목 삭제
    @PostMapping("/delete")
    public String deleteItem(@RequestParam("itemCd") String itemCd) {

        itemService.deleteItem(itemCd);
        return "redirect:/pd/item/itemlist";
    }

    @PostMapping("/item/createform")
    public String registerItemByPage(@ModelAttribute ItemDto itemDto) {

        itemService.saveItem(itemDto);
        return "redirect:createform";
    }
}
