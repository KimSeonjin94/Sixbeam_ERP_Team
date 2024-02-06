package com.erpproject.sixbeam.st.repository;

import com.erpproject.sixbeam.st.entity.WhmoveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhmoveRepository extends JpaRepository<WhmoveEntity,String> {
}
