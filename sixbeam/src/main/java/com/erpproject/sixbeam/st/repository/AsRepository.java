package com.erpproject.sixbeam.st.repository;

import com.erpproject.sixbeam.st.entity.AsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsRepository extends JpaRepository<AsEntity,String> {
}
