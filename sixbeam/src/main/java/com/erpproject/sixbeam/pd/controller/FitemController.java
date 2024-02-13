package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.pd.dto.FitemDto;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.service.FitemService;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@AllArgsConstructor
@RequestMapping("/pd/fitem")
@Controller
@Slf4j
public class FitemController {

    @Autowired
    private ItemRepository itemRepository;

/*    @Autowired
    private final FitemService fitemService;*/

    // 1. id를 조회해 데이터 가져오기
    //
//    Optional<ItemEntity> itemEntity = itemRepository.findById(id).orElse(null);


    // 2. Model에 등록하기


    /*@GetMapping("/{itemCd}")
    public List<FitemDto> getFitemsByItemCd(@PathVariable String itemCd) {
        return fitemService.findByItemCd(itemCd);
    }*/


}
