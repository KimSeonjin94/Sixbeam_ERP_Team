package com.erpproject.sixbeam.ac.repository;


import com.erpproject.sixbeam.ac.entity.BsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BsRepository extends JpaRepository<BsEntity, String> {
    BsEntity findByBsDt(String bsDt);
}
