package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.dto.FitemDto;
import com.erpproject.sixbeam.pd.entity.FitemEntity;
import com.erpproject.sixbeam.pd.entity.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FitemRepository extends JpaRepository<FitemEntity, String> {

}
