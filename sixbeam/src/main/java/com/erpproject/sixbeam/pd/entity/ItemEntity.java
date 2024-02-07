package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "PD_ITEM_TB")
public class ItemEntity {

    @Id
    @Column(name = "ITEM_CD")
    private String itemCd;

    @Column(name = "ITEM_NM")
    private String itemNm;

    @Column(name = "ITEM_STND")
    private String itemStnd;

    @Column(name = "ITEM_UP")
    private Long itemUp;

    // 기존 데이터 수정 기능
/*    public void patch(ItemEntity itemEntity) {
        if (itemEntity.itemNm != null)
            this.itemNm = itemEntity.itemNm;
        if (itemEntity.itemStnd != null)
            this.itemStnd = itemEntity.itemStnd;
        if (itemEntity.itemUp != null)
            this.itemUp = itemEntity.itemUp;
    }*/
}