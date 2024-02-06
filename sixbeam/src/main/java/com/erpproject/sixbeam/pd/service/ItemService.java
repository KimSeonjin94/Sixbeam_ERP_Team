package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemEntity> list() {

        return itemRepository.findAll();
    }

    public ItemEntity selectlist(String id) {
        return itemRepository.findById(id).orElse(null);
    }
}
