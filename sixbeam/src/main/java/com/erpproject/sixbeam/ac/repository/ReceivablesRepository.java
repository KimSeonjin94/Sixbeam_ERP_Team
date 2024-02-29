package com.erpproject.sixbeam.ac.repository;


import com.erpproject.sixbeam.ac.entity.ReceivablesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceivablesRepository extends JpaRepository<ReceivablesEntity, String> {

//    List<ReceivablesEntity> findByCdorNm(String accountCd , String accountNm);
}
