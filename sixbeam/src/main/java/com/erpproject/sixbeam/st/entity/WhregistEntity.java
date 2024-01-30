package com.erpproject.sixbeam.st.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "st_whregist_tb")
public class WhregistEntity {

    @Id
    @Column(name = "whregist_cd")
    private String whregistCd;

    @Column(name = "whregist_nm")
    private String whregistNm;
}
