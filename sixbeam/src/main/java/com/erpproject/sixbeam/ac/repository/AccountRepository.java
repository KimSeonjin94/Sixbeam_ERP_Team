package com.erpproject.sixbeam.ac.repository;


import com.erpproject.sixbeam.ac.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity,String> {

    //구매처 거래처 코드 가져오기 위함(구매)
    @Query("SELECT a FROM AccountEntity a WHERE a.accountEtc = :accountEtc")
    List<AccountEntity> findAccountCdByEtc(@Param("accountEtc") String accountEtc);

}
