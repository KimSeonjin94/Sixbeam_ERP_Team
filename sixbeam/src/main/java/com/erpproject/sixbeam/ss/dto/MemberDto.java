package com.erpproject.sixbeam.ss.dto;

import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.MemberEntity;
import lombok.Data;

@Data
public class MemberDto {
    private String memberId;
    private String memberNm;
    private String memberPhone;
    private String memberAddr;
    private EstimateEntity estimateEntity;


    public MemberEntity toEntity(){
        MemberEntity memberEntity=new MemberEntity();
        memberEntity.setMemberId(memberId);
        memberEntity.setMemberNm(memberNm);
        memberEntity.setMemberPhone(memberPhone);
        memberEntity.setMemberAddr(memberAddr);
        memberEntity.setEstimateEntity(estimateEntity);
        return memberEntity;

    }

}
