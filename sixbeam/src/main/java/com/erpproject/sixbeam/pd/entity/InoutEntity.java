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
    @Column(name ="INOUT_CMPT_CD", nullable = false)
    private String inoutCmptCd;

    @ManyToOne
    @JoinColumn(name="EI_ID")
    private EmpInfoEntity empInfoEntity;

    @ManyToOne
    @JoinColumn(name = "WMMOVE_CD")
    private WhmoveEntity whMoveEntity;

}
