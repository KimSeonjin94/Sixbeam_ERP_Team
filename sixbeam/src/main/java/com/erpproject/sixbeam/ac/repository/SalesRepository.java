package com.erpproject.sixbeam.ac.repository;


import com.erpproject.sixbeam.ac.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<SalesEntity,String> {
}
