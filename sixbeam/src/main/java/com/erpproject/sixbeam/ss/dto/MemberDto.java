package com.erpproject.sixbeam.ss.dto;

import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.MemberEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MemberDto {
    private String memberId;
    private String memberNm;
    private String memberPhone;
    private String memberAddr;
    private String estimateCd;


    public MemberEntity toEntity(){
        MemberEntity memberEntity=new MemberEntity();

        memberEntity.setMemberId(memberId);
        memberEntity.setMemberNm(memberNm);
        memberEntity.setMemberPhone(memberPhone);
        memberEntity.setMemberAddr(memberAddr);
        EstimateEntity estimateEntity = new EstimateEntity();
        estimateEntity.setEstimateCd(estimateCd);
        memberEntity.setEstimateEntity(estimateEntity);

        return memberEntity;

    }

}
