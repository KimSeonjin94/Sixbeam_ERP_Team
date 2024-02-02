package com.erpproject.sixbeam.ac.repository;


import com.erpproject.sixbeam.ac.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity,String> {
}
