package com.erpproject.sixbeam.st.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "ST_WHMOVE_TB")
public class WhmoveEntity {

    @Id
    @Column(name = "WH_MOVE_CD")
    private String whMoveCd;

    @Column(name = "EI_ID")
    private String eiId;

    @Column(name = "WH_MOVE_DT")
    private LocalDate whMoveDt;

    @Column(name = "ITEM_CD")
    private String itemCd;

    @Column(name = "WH_REGIST_CD")
    private String whRegistCd;

    @Column(name = "WH_MOVE_AMT")
    private Integer whMoveAmt;

    @Column(name = "WH_MOVE_GB")
    private String whMoveGb;

}
