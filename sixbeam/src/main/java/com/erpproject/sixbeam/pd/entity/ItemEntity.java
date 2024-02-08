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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_CD")
    private String itemCd;

    @Column(name = "ITEM_NM")
    private String itemNm;

    @Column(name = "ITEM_STND")
    private String itemStnd;

    @Column(name = "ITEM_UP")
    private Long itemUp;
}