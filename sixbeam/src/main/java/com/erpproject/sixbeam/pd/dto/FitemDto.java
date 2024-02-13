package com.erpproject.sixbeam.pd.dto;

import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.RitemEntity;
import lombok.AllArgsConstructor;

public class FitemDto {

    private String itemCd;
    private String itemNm;
    private String itemStnd;
    private Long itemUp;

    public RitemEntity toEntity() {
        return new RitemEntity(itemCd, itemNm, itemStnd, itemUp);
    }
}
