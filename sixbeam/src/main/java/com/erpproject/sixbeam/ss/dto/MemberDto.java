package com.erpproject.sixbeam.ss.dto;

import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.MemberEntity;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class MemberDto {
    private String memberId;
    private String memberNm;
    private String memberPhone;
    private String memberAddr;
    private EstimateEntity estimateEntity;

    public SaleEntity toEntity(){
        return new SaleEntity(memberId,memberNm,memberPhone,memberAddr,estimateEntity);
    }

}
