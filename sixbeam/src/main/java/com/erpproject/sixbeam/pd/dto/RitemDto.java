package com.erpproject.sixbeam.pd.dto;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.RitemEntity;
import lombok.AllArgsConstructor;

public class RitemDto {

    private String itemCd;
    private ItemEntity itemEntity;

    public RitemEntity toEntity() {
        return new RitemEntity(itemCd, itemEntity);
    }
}