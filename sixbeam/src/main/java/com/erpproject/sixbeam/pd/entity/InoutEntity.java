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
@Table(name = "pd_inout_tb")
public class InoutEntity {

    @Id
    @Column(name ="inout_cmpt_cd", nullable = false)
    private String inoutCmptCd;

    @ManyToOne
    @JoinColumn(name="empinfoId")
    private EmpInfoEntity empInfoEntity;

    @ManyToOne
    @JoinColumn(name = "order_cd")
    private OrderEntity orderEntity;

    @Column(name = "inout_dt")
    private LocalDate inoutDt;

    @ManyToOne
    @JoinColumn(name = "whregist_cd")
    private WhregistEntity whregistEntity;

    @ManyToOne
    @JoinColumn(name = "item_cd")
    private ItemEntity itemEntity;
}
