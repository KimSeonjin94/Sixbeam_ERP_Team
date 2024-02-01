package com.erpproject.sixbeam.ac.repository;


import com.erpproject.sixbeam.ac.entity.BsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface BsRepository extends JpaRepository<BsEntity, LocalDate> {
}
