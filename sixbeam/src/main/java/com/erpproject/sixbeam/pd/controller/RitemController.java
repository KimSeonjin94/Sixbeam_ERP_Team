package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.RitemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.repository.RitemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/pd/rawitem")
@RequiredArgsConstructor
@Controller
@ControllerAdvice
public class RitemController {

    private final ItemRepository itemRepository;
    private final RitemRepository ritemRepository;

    @GetMapping("/extractrawitem")
    public String saveRawItem() {

        // R로 시작하는 데이터 추출
        List<ItemEntity> itemsStartingWithR = itemRepository.findByItemCdStartingWith("R");

        // 추출된 데이터를 RitemEntity로 변환하여 저장
        for (ItemEntity item : itemsStartingWithR) {
            RitemEntity ritemEntity = new RitemEntity();
            ritemEntity.setItemCd(item.getItemCd());

            // RitemRepository를 사용하여 저장
            ritemRepository.save(ritemEntity);
        }

        return "contents/pd/rawitem_list";
    }
}