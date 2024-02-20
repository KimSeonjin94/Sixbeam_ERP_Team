package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.pd.dto.ItemDto;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    // 모든 품목을 가져오는 메서드
    public List<ItemEntity> getList() {

        return itemRepository.findAll();
    }

    // itemCd가 F로 시작하는 품목을 가져오는 메서드
    public List<ItemEntity> getFlist() {

        return itemRepository.findByItemCdStartingWith("F");
    }

    // itemCd가 R로 시작하는 품목을 가져오는 메서드
    public List<ItemEntity> getRlist() {

        return itemRepository.findByItemCdStartingWith("R");
    }


    public List<ItemEntity> getCPU() {

        return itemRepository.findByItemCdContainingKeyword("CPU");
    }

    public List<ItemEntity> getMB() {

        return itemRepository.findByItemCdContainingKeyword("MAINBOARD");
    }

    public List<ItemEntity> getVGA() {

        return itemRepository.findByItemCdContainingKeyword("VGA");
    }

    public List<ItemEntity> getRAM() {

        return itemRepository.findByItemCdContainingKeyword("RAM");
    }

    public List<ItemEntity> getSSD() {

        return itemRepository.findByItemCdContainingKeyword("SSD");
    }

    public List<ItemEntity> getHDD() {

        return itemRepository.findByItemCdContainingKeyword("HDD");
    }

    public List<ItemEntity> getPOWER() {

        return itemRepository.findByItemCdContainingKeyword("POWER");
    }

    public List<ItemEntity> getCASE() {

        return itemRepository.findByItemCdContainingKeyword("CASE");
    }

    public void saveItem(ItemDto itemDto) {
        ItemEntity itemEntity = itemDto.toEntity();
        itemRepository.save(itemEntity);
    }

    public void updateItem(ItemDto itemDto) {
        // dto -> entity
        ItemEntity editItemEntity = itemDto.toEntity();
        // itemCd에 해당하는 entity 검색
        ItemEntity itemEntity = itemRepository.findById(editItemEntity.getItemCd())
                .orElseThrow(() -> new IllegalArgumentException("Invalid account Id:" + editItemEntity.getItemCd()));
        // 각 필드 업데이트
        itemEntity.setItemCd(editItemEntity.getItemCd());
        itemEntity.setItemNm(editItemEntity.getItemNm());
        itemEntity.setItemStnd(editItemEntity.getItemStnd());
        itemEntity.setItemUp(editItemEntity.getItemUp());
        // 엔티티 반환 후 저장
        itemRepository.save(itemEntity);
    }

    @Transactional
    public void deleteItem(String itemCd) {

        itemRepository.findById(itemCd).ifPresent(itemRepository::delete);
    }
}