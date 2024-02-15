package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/pd/item")
@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/new")
    public String newItemDto() {
        return "/new";
    }

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
}
/*

    // 품목 선택 조회
    @GetMapping("/rawitem_list/{id}")
    public String selectList(@PathVariable String id, Model model) {


        // 1. id 값으로 조회해서 데이터 가져오기 해당 id 값이 없으면 null을 반환
        ItemEntity itemEntity = itemRepository.findById(id).orElse(null);
        // ArrayList<ItemEntity> itemEntities = itemRepository.findAll();

        // 2. 모델에 데이터 등록
        model.addAttribute("itemEntity", itemEntity);

        // 3. 선택 데이터 뷰페이지 반환
        return "contents/pd/item_list";
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
}*/
