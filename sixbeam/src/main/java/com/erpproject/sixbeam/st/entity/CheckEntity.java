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
@Table(name = "st_check_tb")
public class CheckEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "check_cd")
    private Long checkCd;

    @Column(name = "check_amt")
    private Integer checkAmt;

    @ManyToOne
    @JoinColumn(name = "whmove_cd")
    private WhmoveEntity whmoveEntity;

    @ManyToOne
    @JoinColumn(name = "whregist_cd")
    private WhregistEntity whregistEntity;

    @ManyToOne
    @JoinColumn(name = "item_cd")
    private ItemEntity itemEntity;

    @Column(name = "check_pr")
    private Integer checkPr;

}
    /* 2024-02-08 이전
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


     */

