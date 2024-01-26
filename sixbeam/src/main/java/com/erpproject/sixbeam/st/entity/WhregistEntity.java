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
@Table(name = "ST_WHREGIST_TB")
public class WhregistEntity {

    @Id
    @Column(name = "WH_REGIST_CD")
    private String whRegistCd;

    @Column(name = "WH_REGIST_NM")
    private String whRegistNm;
}
