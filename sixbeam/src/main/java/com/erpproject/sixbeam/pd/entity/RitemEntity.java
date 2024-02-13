package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "PD_RITEM_TB")
public class RitemEntity {

    @Id
    @Column(name = "ITEM_CD", insertable = false, updatable = false)
    private String itemCd;

    @Column(name = "ITEM_NM")
    private String itemNm;

    @Column(name = "ITEM_STND")
    private String itemStnd;

    @Column(name = "ITEM_UP")
    private Long itemUp;
}