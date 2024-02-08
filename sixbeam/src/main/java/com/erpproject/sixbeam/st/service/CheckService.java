package com.erpproject.sixbeam.st.service;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import com.erpproject.sixbeam.st.entity.CheckEntity;
import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import com.erpproject.sixbeam.st.repository.CheckRepository;
import com.erpproject.sixbeam.st.repository.WhmoveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@RequiredArgsConstructor
@Service
public class CheckService {

    private final CheckRepository checkRepository;

    private final WhmoveRepository whmoveRepository;

    public List<CheckEntity> getList() {
        return this.checkRepository.findAll();
    }

    public int getAmountByDate(WhmoveEntity whmoveEntity, ItemEntity itemEntity, LocalDate date){
    CheckEntity checkEntity = checkRepository.findByWhmoveEntityAndItemEntity(whmoveEntity, itemEntity);
    int currentAmount = checkEntity != null ? checkEntity.getCheckAmt() : 0;
    int totalMovementAmount = checkRepository.countByWhmoveEntityAndItemEntityAndCheckDtBefore(whmoveEntity,itemEntity, date);
    return currentAmount + totalMovementAmount;
    }

}
