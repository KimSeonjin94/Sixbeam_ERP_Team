package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.pd.dto.ItemDto;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/pd/item")
@Controller
@Slf4j
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/pd/new")
    public String newItemDto() {
        return "pd/new";
    }


    // 품목 전체 조회
    @GetMapping("/items")
    public String list(Model model) {

        // 1. 모든 데이터 가져오기
        List<ItemEntity> itemEntities = itemRepository.findAll();

        // 2. 모델에 데이터 등록
        model.addAttribute("itemEntities", itemEntities);

        // 3. 모든 데이터 뷰페이지 반환
        return "items/item_list";
    }

    // 품목 선택 조회
    @GetMapping("/select_itemList/{id}")
    public String selectList(@PathVariable String id, Model model) {

        // 1. id 값으로 조회해서 데이터 가져오기
        ItemEntity itemEntity = itemRepository.findById(id).orElse(null);
        // ArrayList<ItemEntity> itemEntities = itemRepository.findAll();

        // 2. 모델에 데이터 등록
        model.addAttribute("item", itemEntity);

        // 3. 선택 데이터 뷰페이지 반환
        return "pd/select_item_list";
    }

    @PostMapping("/items/create")
    public String createItem(ItemDto itemDto) {

        // 1. DTO를 Entity로 변환
        ItemEntity itemEntity = itemDto.toEntity();

        // 2. Repository로 Entity를 DB에 저장
        ItemEntity saved = itemRepository.save(itemEntity);

        // 3.
        return "redirect:/item/";
    }
}
