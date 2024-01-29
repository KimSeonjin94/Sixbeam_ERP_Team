package com.erpproject.sixbeam.pur.entity;

import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name="PUR_INPUT_TB")
public class InputEntity {
    @Column(name = "PUR_DT", nullable = false)
    private LocalDate purDt;
    @Id
    @Column(name = "PI_CD")
    private String piCd;
    @Column(name = "PO_CD", nullable = false)
    private String orinputEntity;
    @Column(name = "WH_MOVE_CD", nullable = false)
    private String whmoveEntity;
    @Column(name = "PUR_PROG_ST", nullable = false)
    private String purProgSt;
    @Column(name = "SLIP_ISSU_DT")
    private LocalDate slipIssuDt;
    @Column(name = "SLIP_ISSU_FL", columnDefinition = "TINYINT(1)", nullable = false)
    private boolean slipIssuFl;
}
