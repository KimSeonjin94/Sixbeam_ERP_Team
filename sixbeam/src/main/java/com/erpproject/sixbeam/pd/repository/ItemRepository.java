package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.ItemEntity;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemEntity, String> {

    Optional<ItemEntity> findById(String id);
}
