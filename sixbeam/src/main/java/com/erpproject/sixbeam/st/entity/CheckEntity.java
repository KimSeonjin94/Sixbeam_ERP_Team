package com.erpproject.sixbeam.st.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}