package com.erpproject.sixbeam.st.entity;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@IdClass(CheckEntityId.class)
@Table(name = "st_check_tb")
public class CheckEntity {
    @Id
    @Column(name = "check_dt")
    private LocalDate checkDt;

    @Id
    @ManyToOne
    @JoinColumn(name = "item_cd")
    private ItemEntity itemEntity;

    @Column(name = "check_up")
    private Integer checkUp;

    @Column(name = "check_pr")
    private Integer checkPr;

    @Column(name = "check_amt")
    private Integer checkAmt;
}
