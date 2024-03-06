package com.erpproject.sixbeam.pd.entity;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

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
    @JoinColumn(name="empinfoId")
    private EmpInfoEntity empInfoEntity;

    @ManyToOne
    @JoinColumn(name = "ORDER_CD")
    private OrderEntity orderEntity;

    @Column(name = "ORDER_ST")
    private boolean orderSt;

    @Column(name = "INOUT_DT")
    private LocalDate inoutDt;

    @ManyToOne
    @JoinColumn(name = "WHREGIST_CD")
    private WhregistEntity whregistEntity;

    @ManyToOne
    @JoinColumn(name = "ITEM_CD")
    private ItemEntity itemEntity;
}
