package com.erpproject.sixbeam.ss.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.ToOne;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="ss_member_tb")
public class MemberEntity {

    @Column(name = "member_id")
    private String memberId;
    @Column(name = "member_nm")
    private String memberNm;
    @Column(name = "member_phone")
    private String memberPhone;
    @Column(name = "member_addr")
    private String memberAddr;
    @Id
    @Column(name="estimate_cd")
    private String estimateCd;

    @ManyToOne
    @JoinColumn(name = "estimate_cd", referencedColumnName = "estimate_cd", insertable = false, updatable = false)
    private EstimateEntity estimateEntity;






}
