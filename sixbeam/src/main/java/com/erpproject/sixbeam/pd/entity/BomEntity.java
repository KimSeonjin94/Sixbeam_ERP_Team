package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;


@IdClass(BomEntityId.class)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "pd_bom_tb")
public class BomEntity {

    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fitem_cd", referencedColumnName = "item_Cd")
    private FitemEntity fitemEntity;

    @Id
    @ManyToOne
    @JoinColumn(name = "ritem_cd", referencedColumnName = "item_Cd")
    private RitemEntity ritemEntity;

    @Column(name = "bom_use_mt")
    private Long bomUseMt;

    @Column(name = "bom_work_tm", nullable = true)
    private Time bomWorkTm;
}