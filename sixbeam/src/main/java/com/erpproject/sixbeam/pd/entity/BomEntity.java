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
@Table(name = "PD_BOM_TB")
public class BomEntity {

    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FITEM_CD", referencedColumnName = "item_Cd")
    private FitemEntity fitemEntity;

    @Id
    @ManyToOne
    @JoinColumn(name = "RITEM_CD", referencedColumnName = "item_Cd")
    private RitemEntity ritemEntity;

    @Column(name = "BOM_USE_MT")
    private Long bomUseMt;

    @Column(name = "BOM_WORK_TM", nullable = true)
    private Time bomWorkTm;
}