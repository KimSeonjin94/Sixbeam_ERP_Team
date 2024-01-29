package com.erpproject.sixbeam.pur.entity;

import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name="PUR_INPUT_TB")
public class InputEntity {
    @NotNull
    @Column(name = "PUR_DT")
    private LocalDate purDt;
    @Id
    @Column(name = "PI_CD")
    private String piCd;
    @NotNull
    @Column(name = "PO_CD")
    private OrinPutEntity orinputEntity;
    @NotNull
    @Column(name = "WH_MOVE_CD")
    private WhmoveEntity whmoveEntity;
    @NotNull
    @Column(name = "PUR_PROG_ST")
    private String purProgSt;
    @Column(name = "SLIP_ISSU_DT")
    private LocalDate slipIssuDt;
    @NotNull
    @Column(name = "SLIP_ISSU_FL", columnDefinition = "TINYINT(1)")
    private boolean slipIssuFl;
}
