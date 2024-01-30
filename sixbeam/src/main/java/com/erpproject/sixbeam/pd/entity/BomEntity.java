package com.erpproject.sixbeam.pd.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "PD_BOM_TB")
@IdClass(BomEntityId.class)
public class BomEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "fitem_entity_id")
    private FitemEntity fitemEntities;

    @Id
    @ManyToOne
    @JoinColumn(name = "ritem_entity_id")
    private RitemEntity ritemEntity;

    @Column
    private int bomUseMt;

    @Column
    private Time bomWorkTm;
}

@Getter
@Setter
class BomEntityId implements Serializable {
    private String fitemEntityId;
    private String ritementityId;

    // 생성자, equals, hashCode 등을 구현해야 합니다.

    // getters, setters
}