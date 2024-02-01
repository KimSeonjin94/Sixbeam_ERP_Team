package com.erpproject.sixbeam.pd.entity;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import jakarta.persistence.*;

@Entity
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
