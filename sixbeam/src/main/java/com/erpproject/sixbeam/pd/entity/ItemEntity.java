package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "PD_ITEM_TB")
public class ItemEntity {

    @Id
    @Column(name = "ITEM_CD")
    private String itemCd;


}