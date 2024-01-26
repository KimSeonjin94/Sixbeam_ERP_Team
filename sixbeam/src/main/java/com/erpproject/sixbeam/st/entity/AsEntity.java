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
@Table(name = "ST_AS_TB")
public class AsEntity {

    @Column(name = "AS_DT")
    private LocalDate asDt;

    @Id
    @Column(name = "AS_CD")
    private String asCd;

    @Column(name = "EI_ID")
    private String eiId;

    @Column(name = "ACCOUNT_CD")
    private String accountCd;

    @Column(name = "WH_MOVE_CD")
    private String whMoveCd;

    @Column(name = "AS_ST")
    private String asSt;

    @Column(name = "AS_COMPLETE_DT")
    private LocalDate asCompleteDt;

    @Column(name = "AS_TI")
    private String asTi;

    @Column(name = "AS_MO")
    private String asMo;

}

