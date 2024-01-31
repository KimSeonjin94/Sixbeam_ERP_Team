package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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
    private int itemUp;
}