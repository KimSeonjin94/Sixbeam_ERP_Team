package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.pd.dto.ItemDto;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class ItemController {


    private final ItemRepository itemRepository;

    @GetMapping("/new")
    public String newItemDto() {
        return "/new";
    }


    // 품목 전체 조회
    @GetMapping("/itemlist")
    public String list(Model model) {

        // 1. 모든 데이터 가져오기
        List<ItemEntity> itemEntities = itemRepository.findAll();

        // 2. 모델에 데이터 등록
        model.addAttribute("itemEntities", itemEntities);

        // 3. 모든 데이터 뷰페이지 반환
        return "contents/pd/item_list";
    }

    // 품목 선택 조회
    @GetMapping("/rawitem_list/{id}")
    public String selectList(@PathVariable String id, Model model) {


        // 1. id 값으로 조회해서 데이터 가져오기 해당 id 값이 없으면 null을 반환
        ItemEntity itemEntity = itemRepository.findById(id).orElse(null);
        // ArrayList<ItemEntity> itemEntities = itemRepository.findAll();

        // 2. 모델에 데이터 등록
        model.addAttribute("itemEntity", itemEntity);

        // 3. 선택 데이터 뷰페이지 반환
        return "contents/pd/rawitem_list";
    }

    //품목 등록
    @PostMapping("/items/create")
    public String createItem(ItemDto itemDto) {

        // 1. DTO를 Entity로 변환
        ItemEntity itemEntity = itemDto.toEntity();

        // 2. Repository로 Entity를 DB에 저장
        ItemEntity saved = itemRepository.save(itemEntity);

        // 3. 페이지 새로고침
        return "redirect:/item/";
    }
}