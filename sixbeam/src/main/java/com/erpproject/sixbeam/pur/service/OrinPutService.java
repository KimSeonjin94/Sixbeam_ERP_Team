package com.erpproject.sixbeam.pur.service;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.repository.AccountRepository;
import com.erpproject.sixbeam.hr.entity.EmpInfoEntity;
import com.erpproject.sixbeam.hr.repository.EmpInfoRepository;
import com.erpproject.sixbeam.pur.entity.OrinPutEntity;
import com.erpproject.sixbeam.pur.repository.OrinPutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrinPutService {
    private final OrinPutRepository orinPutRepository;
    private final AccountRepository accountRepository;
    private final EmpInfoRepository empInfoRepository;

    public List<OrinPutEntity> getList() {
        //return this.orinPutRepository.findAllByOrderByORINPUT_CDDesc();
        return this.orinPutRepository.findAll();
    }

    public List<AccountEntity> getactList() {
        return this.accountRepository.findAll();
    }

    public List<EmpInfoEntity> getemplist(){
        return this.empInfoRepository.findAll();
    }
}
