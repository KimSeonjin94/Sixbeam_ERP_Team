package com.erpproject.sixbeam.pd.controller;

import com.erpproject.sixbeam.pd.dto.FitemDto;
import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.RitemEntity;
import com.erpproject.sixbeam.pd.repository.FitemRepository;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.service.FitemService;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RequestMapping("/pd/finitem")
@RequiredArgsConstructor
@Controller
@ControllerAdvice
public class FitemController {


    private final ItemRepository itemRepository;
    private final FitemRepository fitemRepository;

    @GetMapping("/extractfinitem")
    public String saveRawItem() {

        // R로 시작하는 데이터 추출
        List<ItemEntity> itemsStartingWithR = itemRepository.findByItemCdStartingWith("F");

        // 추출된 데이터를 FitemEntity로 변환하여 저장
        for (ItemEntity item : itemsStartingWithR) {
            FitemEntity fitemEntity = new FitemEntity();
            fitemEntity.setItemCd(item.getItemCd());

            // FitemRepository를 사용하여 저장
            fitemRepository.save(fitemEntity);
        }

        return "contents/pd/finitem_list";
    }

}
