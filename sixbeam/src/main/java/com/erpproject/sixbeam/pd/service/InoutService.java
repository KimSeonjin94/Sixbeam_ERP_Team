package com.erpproject.sixbeam.pd.service;

import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.pd.dto.InoutDto;
import com.erpproject.sixbeam.pd.dto.OrderDto;
import com.erpproject.sixbeam.pd.entity.InoutEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.pd.entity.OrderEntity;
import com.erpproject.sixbeam.pd.repository.InoutRepository;
import com.erpproject.sixbeam.pd.repository.ItemRepository;
import com.erpproject.sixbeam.st.entity.WhregistEntity;
import com.erpproject.sixbeam.st.repository.WhregistRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InoutService {

    private final InoutRepository inoutRepository;
    private final ItemRepository itemRepository;
    private final EmpInfoRepository empInfoRepository;
    private final WhregistRepository whregistRepository;

    public List<InoutEntity> getList() {

        return inoutRepository.findAll();
    }

    public List<EmpInfoEntity> getEmpList() {

        return empInfoRepository.findAll();
    }

    public List<WhregistEntity> getWhList() {

        return whregistRepository.findAll();
    }

    public List<InoutEntity> getIdList(String inoutCd) {

        return inoutRepository.findByInoutCd(inoutCd);
    }

    /*public void saveInout(List<InoutDto> inoutDtos) {

        for (InoutDto inoutDto : inoutDtos) {
            EmpInfoEntity empInfoEntity = empInfoRepository.findById(inoutDto).getEmpInfoEntity().getEmpInfoId());
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));
            ItemEntity itemEntity = itemRepository.findById(inoutDto.getItemEntity().getItemCd())
                    .orElseThrow(() -> new EntityNotFoundException("Item not found"));

            inoutDto.setEmpInfoEntity(empInfoEntity);
            inoutDto.setItemEntity(itemEntity);

            OrderEntity inoutEntity = inoutDto.toEntity();
            String newinoutCd = generateNewInoutCd(inoutDto.getInoutInstDt());

            inoutEntity.setInoutCd(newInoutCd);
            inoutRepository.save(inoutEntity);
        }
    }*/
}
