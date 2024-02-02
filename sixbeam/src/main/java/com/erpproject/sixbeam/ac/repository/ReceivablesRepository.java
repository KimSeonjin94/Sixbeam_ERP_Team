package com.erpproject.sixbeam.ac.repository;


import com.erpproject.sixbeam.ac.entity.AccountEntity;
import com.erpproject.sixbeam.ac.entity.ReceivablesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceivablesRepository extends JpaRepository<ReceivablesEntity, String> {
}
