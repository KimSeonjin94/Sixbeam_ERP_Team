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
@Table(name = "pd_item_tb")
public class ItemEntity {

    @Id
    @Column(name = "item_cd")
    private String itemCd;

    @Column(name = "item_nm")
    private String itemNm;

    @Column(name = "item_stnd")
    private String itemStnd;

    @Column(name = "item_up")
    private Long itemUp;
}