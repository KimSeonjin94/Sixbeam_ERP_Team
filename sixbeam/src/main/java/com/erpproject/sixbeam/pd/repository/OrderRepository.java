package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {
}
