package com.erpproject.sixbeam.pur.entity;

import com.erpproject.sixbeam.st.entity.WhregistEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="PUR_INPUT_TB")
public class InputEntity {
    @Column(name = "INPUTPUR_DT", nullable = false)
    private LocalDate inputPurDt;
    @Id
    @Column(name = "INPUTPUR_CD")
    private String inputPurCd;
    @ManyToOne
    @JoinColumn(name = "ORINPUT_CD", nullable = false)
    private OrinPutEntity orinputEntity;
    @ManyToOne
    @JoinColumn(name = "WHREGIST_CD")
    private WhregistEntity whregistEntity;
    @Column(name = "INPUTPRG_ST", nullable = false)
    private String inputPrgSt;
    @Column(name = "INPUTSI_DT")
    private LocalDate inputSiDt;
    @Column(name = "INPUTSI_FL", columnDefinition = "TINYINT(1)", nullable = false)
    private boolean inputSiFl;
}
