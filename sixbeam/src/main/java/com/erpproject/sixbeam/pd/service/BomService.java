package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.pd.dto.BomDto;
import com.erpproject.sixbeam.pd.entity.BomEntity;
import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.RitemEntity;
import com.erpproject.sixbeam.pd.repository.BomRepository;
import com.erpproject.sixbeam.pd.repository.FitemRepository;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.pd.repository.RitemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BomService {

    private final BomRepository bomRepository;
    private final ItemRepository itemRepository;
    private final FitemRepository fitemRepository;
    private final RitemRepository ritemRepository;

    // 모든 품목을 가져오는 메서드
    public List<BomEntity> getList() {

        return bomRepository.findAll();
    }

    public List<BomEntity> getIdList(String id) {

        return bomRepository.findByFitemEntity_ItemCd(id);
    }

    public Optional<ItemEntity> getItemCd(String id) {

        return itemRepository.findById(id);
    }

    public void create(List<BomDto> bomDtos) {

        List<BomEntity> bomEntities = new ArrayList<>();

        for (BomDto bomDto : bomDtos) {

            FitemEntity fitemEntity = fitemRepository.findById(bomDto.getFitemEntity().getItemCd()).orElseThrow(() -> new EntityNotFoundException("Fitem not found"));
            RitemEntity ritemEntity = ritemRepository.findById(bomDto.getRitemEntity().getItemCd()).orElseThrow(() -> new EntityNotFoundException("Ritem not found"));

            bomDto.setFitemEntity(fitemEntity);
            bomDto.setRitemEntity(ritemEntity);

            BomEntity bomEntity = bomDto.toEntity();

            bomEntities.add(bomEntity);
        }
        bomRepository.saveAll(bomEntities);
    }

    public void updateAll(List<BomDto> bomDtos) {

        for (BomDto bomDto : bomDtos) {

            FitemEntity fitemEntity = fitemRepository.findById(bomDto.getFitemEntity().getItemCd()).orElseThrow(() -> new EntityNotFoundException("Fitem not found"));
            RitemEntity ritemEntity = ritemRepository.findById(bomDto.getRitemEntity().getItemCd()).orElseThrow(() -> new EntityNotFoundException("Ritem not found"));

            bomDto.setFitemEntity(fitemEntity);
            bomDto.setRitemEntity(ritemEntity);

            BomEntity bomEntity = bomDto.toEntity();

            bomRepository.save(bomEntity);
        }
    }
}