package com.erpproject.sixbeam.st.repository;

import com.erpproject.sixbeam.st.entity.WhregistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhregistRepository extends JpaRepository<WhregistEntity, String> {

    @Query("SELECT MAX(w.whregistCd) FROM WhregistEntity w")
    String getMaxWhregistCd();

    List<WhregistEntity> findByWhregistCd(String id);

}
