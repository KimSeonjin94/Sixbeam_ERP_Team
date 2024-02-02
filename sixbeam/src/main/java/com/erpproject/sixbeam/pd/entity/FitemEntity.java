package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "PD_FITEM_TB")
public class FitemEntity {

    @Id
    @Column(name = "ITEM_CD", insertable = false, updatable = false)
    private String itemCd;

    @ManyToOne
    @JoinColumn(name = "ITEM_CD", referencedColumnName = "ITEM_CD")
    private ItemEntity itemEntity;
}