package com.erpproject.sixbeam.pd.entity;

import com.erpproject.sixbeam.pd.repository.BomRepository;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Time;


@IdClass(BomEntityId.class)
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "PD_BOM_TB")
public class BomEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "FITEM_CD")
    private FitemEntity fitemEntities;

    @Id
    @ManyToOne
    @JoinColumn(name = "RITEM_CD")
    private RitemEntity ritemEntity;

    @Column(name = "BOM_USE_MT")
    private Long bomUseMt;

    @Column(name = "BOM_WORK_TM")
    private Time bomWorkTm;

    public BomEntity(FitemEntity fitemEntity, RitemEntity ritemEntity, int bomUseMt, Time bomWorkTm) {
    }
}