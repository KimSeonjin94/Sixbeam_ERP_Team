package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.pd.dto.ItemDto;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
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

    public ItemEntity updateItem(ItemDto itemDto) {
        // dto -> entity
        ItemEntity editItemEntity = itemDto.toEntity();
        // itemCd에 해당하는 entity 검색
        ItemEntity itemEntity = itemRepository.findById(editItemEntity.getItemCd())
                .orElseThrow(() -> new EntityNotFoundException("ItemCd not found"));
        // 각 필드 업데이트
        itemEntity.setItemCd(editItemEntity.getItemCd());
        itemEntity.setItemNm(editItemEntity.getItemNm());
        itemEntity.setItemStnd(editItemEntity.getItemStnd());
        itemEntity.setItemUp(editItemEntity.getItemUp());
        // 엔티티 반환 후 저장
        return itemRepository.save(itemEntity);
    }
}



    /*// 선택 조회
    public ItemEntity selectlist(String id) {

        return itemRepository.findById(id).orElse(null);
    }

    public ItemEntity create(ItemDto itemDto) {

        // dto -> 엔티티로 변환한 후 itemEntity에 저장
        ItemEntity itemEntity = itemDto.toEntity();

        // itemEntity를 db에 저장
        return itemRepository.save(itemEntity);
    }


    // 수정
    public ItemEntity update(String id, ItemDto itemDto) {

        // 1. DTO -> 엔티티 변환하기
        ItemEntity itemEntity = itemDto.toEntity();

        // 2. 타깃 조회하기
        ItemEntity target = itemRepository.findById(id).orElse(null);

        // 3. 잘못된 요청 처리하기
        if (target == null || id != itemEntity.getItemCd()) {
            // 400, 잘못된 요청 응답!
            return null; // ResponseEntity 반환(Rest 컨트롤러 반환형) -> 컨트롤러 역할
        }

        // 4. 업데이트 및 정상 응답(200)하기
        patchEntity(itemEntity, target); // targetEntity의 정보로 itemEntity를 수정
        ItemEntity updated = itemRepository.save(target); // itemEntity db에 저장
        return updated; //
    }

    // 기존 데이터 수정 기능
    public void patchEntity(ItemEntity itemEntity, ItemEntity patchEntity) {
        if (patchEntity.getItemNm() != null)
            itemEntity.setItemNm(patchEntity.getItemNm());
        if (patchEntity.getItemStnd() != null)
            itemEntity.setItemStnd(patchEntity.getItemStnd());
        if (itemEntity.getItemUp() != null)
            itemEntity.setItemUp(patchEntity.getItemUp());
    }

    // ItemEntity를 FitemEntity와 RitemEntity에 저장
    *//*public void saveItemToEntities(String itemCd) {
        Optional<ItemEntity> itemEntityOptional = itemRepository.findByItemCd(itemCd);
        if (itemEntityOptional.isPresent()) {
            ItemEntity itemEntity = itemEntityOptional.get();

            // FitemEntity에 저장
            FitemEntity fitemEntity = new FitemEntity();
            fitemEntity.setFitemCd(itemEntity.getItemCd());
            fitemEntity.setFitemName(itemEntity.getItemName());
            // 필요한 다른 속성들도 설정

            fitemRepository.save(fitemEntity);

            // RitemEntity에 저장
            RitemEntity ritemEntity = new RitemEntity();
            ritemEntity.setRitemCd(itemEntity.getItemCd());
            ritemEntity.setRitemName(itemEntity.getItemName());
            // 필요한 다른 속성들도 설정

            ritemRepository.save(ritemEntity);
        }
    }*//*
}*/