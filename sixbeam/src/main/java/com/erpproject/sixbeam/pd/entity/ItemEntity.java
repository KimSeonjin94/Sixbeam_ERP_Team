package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PD_ITEM_TB")
public class ItemEntity {

    @Id
    @Column(name = "ITEM_CD")
    private String itemCd;


}