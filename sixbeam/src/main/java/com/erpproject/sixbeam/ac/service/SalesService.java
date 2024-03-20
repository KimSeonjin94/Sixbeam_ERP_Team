package com.erpproject.sixbeam.ac.service;

import com.erpproject.sixbeam.ac.dto.PurDto;
import com.erpproject.sixbeam.ac.dto.SalesDto;
import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.entity.SalesEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import com.erpproject.sixbeam.ac.repository.SalesRepository;
import com.erpproject.sixbeam.pur.entity.InputEntity;
import com.erpproject.sixbeam.ss.SsRowAddEvent;
import com.erpproject.sixbeam.ss.entity.SaleEntity;
import com.erpproject.sixbeam.ss.repository.SaleRepository;
import com.erpproject.sixbeam.ss.service.EstimateService;
import com.erpproject.sixbeam.st.event.WhmoveRowDeletedEvent;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SalesService {
    private final SalesRepository salesRepository;
    SalesEntity salesEntity;

    public List<SalesEntity> getList() {
        return this.salesRepository.findAll();
    }

    private final SaleRepository saleRepository;
    private final EstimateService estimateService;
    private final AccountRepository accountRepository;
    private final ApplicationEventPublisher addRowEvent;
    public List<SaleEntity> getSaleList() {
        return this.saleRepository.findBySaleBillingSt(false);
    }

    public long getSaleList(String accountCd) {
        return estimateService.getAccountTotal(accountCd);
    }

    public void saveSalesSLip(SalesDto salesDto) {
        salesEntity = salesDto.toEntity();

        SaleEntity saleEntity = saleRepository.findById(salesDto.getSaleEntity().getSaleCd())
                .orElseThrow(() -> new IllegalArgumentException("Invalid"));
        AccountEntity accountEntity = accountRepository.findById(salesDto.getAccountEntity().getAccountCd())
                .orElseThrow(() -> new IllegalArgumentException("Invalid"));
        salesEntity.setSaleEntity(saleEntity);
        salesEntity.setAccountEntity(accountEntity);
        salesRepository.save(salesEntity);
        saleEntity.setSaleBillingSt(true);
        saleRepository.save(saleEntity);
        SsRowAddEvent<SaleEntity> saleEntitySsRowAddEvent = new SsRowAddEvent<>(this,saleEntity);
        addRowEvent.publishEvent(saleEntitySsRowAddEvent);
    }

}
