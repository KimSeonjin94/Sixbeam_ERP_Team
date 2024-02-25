package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.RitemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.repository.RitemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RitemService {

    private final ItemRepository itemRepository;
    private final RitemRepository ritemRepository;

    public List<RitemEntity> saveRawItems() {
        List<ItemEntity> itemsStartingWithR = itemRepository.findByItemCdStartingWith("R");
        List<RitemEntity> ritemEntities = new ArrayList<>();
        for (ItemEntity item : itemsStartingWithR) {
            RitemEntity ritemEntity = new RitemEntity();
            ritemEntity.setItemCd(item.getItemCd());
            ritemEntity.setItemNm((item.getItemNm()));
            ritemEntity.setItemStnd((item.getItemStnd()));
            ritemEntity.setItemUp((item.getItemUp()));
            ritemEntities.add(ritemEntity);
        }
        return ritemRepository.saveAll(ritemEntities);
    }

    public List<RitemEntity> getRitemList() {

        return this.ritemRepository.findAll();
    }

    /*public List<RitemEntity> getRitemsByItemCd(String fitemCd) {
        return ritemRepository.findByItemCd(itemCd);

    }*/
}