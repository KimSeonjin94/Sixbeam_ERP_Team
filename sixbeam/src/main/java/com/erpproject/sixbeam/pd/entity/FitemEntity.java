package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PD_FITEM_TB")
public class FitemEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "ITEM_CD")
    private FitemEntity fitemEntity;
}