package com.erpproject.sixbeam.pd.entity;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "PD_INOUT_TB")
public class InoutEntity {

    @Id
    @Column(name = "PD_INOUT_TB")
    private String inoutCmptCd;

    @ManyToOne
    @JoinColumn(name = "EI_ID")
    private EmpInfoEntity empInfoEntity;

    @ManyToOne
    @JoinColumn(name = "WHMOVE_CD")
    private WhmoveEntity whMoveEntity;
}
