package com.erpproject.sixbeam.st.entity;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@IdClass(CheckEntityId.class)
@Table(name = "st_check_tb")
public class CheckEntity {

    @Column(name = "check_dt")
    private LocalDate checkDt;

    @Id
    @ManyToOne
    @JoinColumn(name = "whmove_cd")
    private WhmoveEntity whmoveEntity;

    @Id
    @ManyToOne
    @JoinColumn(name = "item_cd" )
    private ItemEntity itemEntity;

    @Column(name = "check_up")
    private Integer checkUp;

    @Column(name = "check_pr")
    private Integer checkPr;

    @Column(name = "check_amt")
    private Integer checkAmt;
}
