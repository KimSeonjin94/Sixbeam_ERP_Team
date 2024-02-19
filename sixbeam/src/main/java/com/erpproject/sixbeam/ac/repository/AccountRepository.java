package com.erpproject.sixbeam.ac.repository;


import com.erpproject.sixbeam.ac.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity,String> {

    @Query("SELECT a FROM AccountEntity a WHERE a.accountEtc = :accountEtc")
    List<AccountEntity> findAccountCdByEtc(@Param("accountEtc") String accountEtc);

}
