package com.erpproject.sixbeam.pd.dto;

import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FitemDto {

//    private String itemCd;
//    private ItemEntity itemEntity;

    private String itemCd;
    private String itemStnd;

    /*public FitemEntity toEntity() {
        return new FitemEntity(ItemEntity.getitemCd(); ItemEntity.getitemStnd());
    }*/
}
