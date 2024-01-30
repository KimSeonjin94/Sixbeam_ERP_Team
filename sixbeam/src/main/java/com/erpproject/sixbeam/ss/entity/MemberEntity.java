package com.erpproject.sixbeam.ss.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="SS_MEMBER_TB")
public class MemberEntity {
    @Id
    @Column(name = "MEMBER_ID")
    private String memberId;
    @Column(name = "MEMBER_NM")
    private String memberNm;
    @Column(name = "MEMBER_PHONE")
    private String memberPhone;
    @Column(name = "MEMBER_ADDR")
    private String memberAddr;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "ESTIMATE_CD", referencedColumnName = "ESTIMATE_CD"),
            @JoinColumn(name = "ITEM_CD", referencedColumnName = "ITEM_CD")
    })
    private EstimateEntity estimateEntity;





}
