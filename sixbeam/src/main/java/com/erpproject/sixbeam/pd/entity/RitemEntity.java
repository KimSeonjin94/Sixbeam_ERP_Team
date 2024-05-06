package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "pd_ritem_tb")
public class RitemEntity {

    @Id
    @Column(name = "item_cd", insertable = false, updatable = false)
    private String itemCd;

    @Column(name = "item_nm")
    private String itemNm;

    @Column(name = "item_stnd")
    private String itemStnd;

    @Column(name = "item_up")
    private Long itemUp;
}