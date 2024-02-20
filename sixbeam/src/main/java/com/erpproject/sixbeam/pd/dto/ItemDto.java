package com.erpproject.sixbeam.pd.dto;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {

    private String itemCd;
    private String itemNm;
    private String itemStnd;
    private Long itemUp;

    public ItemEntity toEntity() {
        return new ItemEntity(itemCd, itemNm, itemStnd, itemUp);
    }
}