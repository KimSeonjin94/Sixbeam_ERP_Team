package com.erpproject.sixbeam.ss.service;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import com.erpproject.sixbeam.ss.dto.MemberDto;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.entity.MemberEntity;
import com.erpproject.sixbeam.ss.repository.EstimateRepository;
import com.erpproject.sixbeam.ss.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    @Autowired
    private EstimateRepository estimateRepository;

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private AccountRepository accountRepository;

    public Optional<MemberEntity> getMemberList(String estimateCd){
        return memberRepository.findById(estimateCd);
    }

    public List<EstimateEntity> getEstimateList(){
        String name="RTS1010101010";
        Optional<AccountEntity> optionalAccountEntity= accountRepository.findById(name);
        AccountEntity accountEntity =optionalAccountEntity.get();


        return estimateRepository.findByAccountEntity(accountEntity);
    }
    public List<MemberEntity> getMemberList(){
        return memberRepository.findAll();
    }
    public Optional<MemberEntity> getMemberEntity(String id){
        return memberRepository.findById(id);
    }
    public void create(MemberDto memberDto){

        System.out.println(memberDto.getEstimateCd());
        List<EstimateEntity> estimateEntities=estimateRepository.findByEstimateCd(memberDto.getEstimateCd());
        memberDto.setEstimateCd(estimateEntities.get(0).getEstimateCd());
        MemberEntity memberEntity = memberDto.toEntity();
        memberEntity.setEstimateEntity(estimateEntities.get(0));
        memberEntity.setEstimateCd(memberEntity.getEstimateEntity().getEstimateCd());
        memberRepository.save(memberEntity);
    }
}

