package com.erpproject.sixbeam.st.repository;

import com.erpproject.sixbeam.st.entity.WhregistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WhregistRepository extends JpaRepository<WhregistEntity, String> {
}
