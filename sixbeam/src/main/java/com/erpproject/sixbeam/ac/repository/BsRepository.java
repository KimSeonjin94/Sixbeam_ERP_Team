package com.erpproject.sixbeam.ac.repository;


import com.erpproject.sixbeam.ac.entity.BsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BsRepository extends JpaRepository<BsEntity, String> {
    BsEntity findByBsDt(String bsDt);

    @Transactional
    @Modifying
    @Query("UPDATE BsEntity bs SET bs.bsInventories = :totalPayable WHERE bs.bsDt = :bsDt")
    void updateBsInventories(@Param("bsDt") String bsDt, @Param("totalPayable") long totalPayable);
}
