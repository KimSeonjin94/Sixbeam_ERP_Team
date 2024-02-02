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

    @Column
    private String itemNm;

    @Column
    private String itemStnd;

    @Column
    private int itemUp;
}