package com.erpproject.sixbeam.pd.dto;

import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;

public class FitemDto {

    private String itemCd;
    private ItemEntity itemEntity;

    public FitemEntity toEntity() {
        return new FitemEntity(itemCd, itemEntity);
    }
}
