package com.erpproject.sixbeam.ac.repository;


import com.erpproject.sixbeam.ac.entity.IsEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IsRepository extends JpaRepository<IsEntity, String>{
    IsEntity findByIsDt(String isDt);
}
