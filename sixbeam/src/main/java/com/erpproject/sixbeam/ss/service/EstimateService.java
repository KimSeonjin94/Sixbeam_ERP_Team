package com.erpproject.sixbeam.ss.service;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.ss.entity.EstimateEntity;
import com.erpproject.sixbeam.ss.repository.EstimateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class EstimateService {

    private final EstimateRepository estimateRepository;
    private final ItemRepository itemRepository;
    public List<EstimateEntity> getList() {
        List<EstimateEntity> estimateEntities = estimateRepository.findAll();
        // 중복된 estimateCd를 저장할 Set
        Set<String> uniqueEstimateCds = new HashSet<>();

        // 중복 제거된 EstimateEntity 리스트
        List<EstimateEntity> deduplicatedList = new ArrayList<>();

        // 중복을 제거하면서 리스트를 생성
        for (EstimateEntity entity : estimateEntities) {
            if (uniqueEstimateCds.add(entity.getEstimateCd())) {
                // estimateCd가 추가되지 않았으면 중복이므로 추가하지 않음
                deduplicatedList.add(entity);
            }else{
                for(EstimateEntity entity2 :deduplicatedList){
                    if(entity.getEstimateCd().equals(entity2.getEstimateCd())){
                        entity2.setEstimateSp(entity.getEstimateSp());
                        entity2.setEstimateVat(entity.getEstimateVat());
                        entity2.setEstimateTamt(entity.getEstimateTamt());
                    }

                }
            }
        }
        return deduplicatedList;
    }

    public List<EstimateEntity> getIdList(String id) {

        return this.estimateRepository.findByEstimateCd(id);
    }

    public Optional<ItemEntity> getItemCd(String id){
        return this.itemRepository.findByItemCd(id);
    }

}
