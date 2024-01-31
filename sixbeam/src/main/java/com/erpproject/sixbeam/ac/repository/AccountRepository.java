package com.erpproject.sixbeam.ac.repository;

import com.erpproject.sixbeam.ac.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
}
