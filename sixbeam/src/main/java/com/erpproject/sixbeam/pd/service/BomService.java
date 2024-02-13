package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.BomRepository;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BomService {

    private final BomRepository bomRepository;
    private final ItemRepository itemRepository;

    // 모든 품목을 가져오는 메서드
    public List<BomEntity> getList() {

        return bomRepository.findAll();
    }

    // BOM 저장 메서드
/*    public void save(BomEntity bomDto) {

        List<FitemEntity> itemEntities = new ArrayList<>();
        for (ItemEntity item : itemsContainingWith) {
            ItemEntity itemEntity = new ItemEntity();
            itemEntity.setItemCd(item.getItemCd());
            itemEntity.setItemNm((item.getItemNm()));
            itemEntity.setItemStnd((item.getItemStnd()));
            itemEntity.setItemUp((item.getItemUp()));
            itemEntities.add(itemEntity);
        }

        itemRepository.save();
    }*/
}