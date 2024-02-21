package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.FitemRepository;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FitemService {

    private final ItemRepository itemRepository;
    private final FitemRepository fitemRepository;

    public List<FitemEntity> saveFinItems() {
        List<ItemEntity> itemsStartingWithF = itemRepository.findByItemCdStartingWith("F");
        List<FitemEntity> fitemEntities = new ArrayList<>();
        for (ItemEntity item : itemsStartingWithF) {
            FitemEntity fitemEntity = new FitemEntity();
            fitemEntity.setItemCd(item.getItemCd());
            fitemEntity.setItemNm((item.getItemNm()));
            fitemEntity.setItemStnd((item.getItemStnd()));
            fitemEntity.setItemUp((item.getItemUp()));
            fitemEntities.add(fitemEntity);
        }
        return fitemRepository.saveAll(fitemEntities);

    }

    public List<FitemEntity> getFitemList() {
        return this.fitemRepository.findAll();
    }
}
