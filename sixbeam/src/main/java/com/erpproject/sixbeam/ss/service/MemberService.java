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

import java.util.*;

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
        List<EstimateEntity> estimateEntities =estimateRepository.findByAccountEntity(accountEntity);
        Set<String> uniqueEstimateCds = new HashSet<>();

        // 중복 제거된 EstimateEntity 리스트
        List<EstimateEntity> deduplicatedList = new ArrayList<>();

        // 중복을 제거하면서 리스트를 생성
        for (EstimateEntity entity : estimateEntities) {
            if (uniqueEstimateCds.add(entity.getEstimateCd())) {
                // estimateCd가 추가되지 않았으면 중복이므로 추가하지 않음
                deduplicatedList.add(entity);
            } else {
                for (EstimateEntity entity2 : deduplicatedList) {
                    if (entity.getEstimateCd().equals(entity2.getEstimateCd())) {
                        entity2.setEstimateSp(entity2.getEstimateSp()+entity.getEstimateSp());
                        entity2.setEstimateVat(entity.getEstimateVat()+entity2.getEstimateVat());
                        entity2.setEstimateTamt(entity.getEstimateTamt()+entity2.getEstimateTamt());
                    }

                }
            }
        }
        List<MemberEntity> memberEntities = this.getMemberList();
        for(MemberEntity memberEntity:memberEntities){
            Iterator<EstimateEntity> it = deduplicatedList.iterator();
            while (it.hasNext()) {
                if (it.next().getEstimateCd().equals(memberEntity.getEstimateCd())) {
                    it.remove();
                }
            }
        }
        return deduplicatedList;
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

