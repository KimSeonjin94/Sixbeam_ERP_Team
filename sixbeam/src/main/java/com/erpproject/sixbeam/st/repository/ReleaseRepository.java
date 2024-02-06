package com.erpproject.sixbeam.st.repository;

import com.erpproject.sixbeam.st.entity.ReleaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends JpaRepository<ReleaseEntity, String> {
}
