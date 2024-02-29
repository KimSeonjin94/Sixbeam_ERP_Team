package com.erpproject.sixbeam.pd.repository;

import com.erpproject.sixbeam.pd.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {

    @Query("SELECT MAX(o.orderCd) FROM OrderEntity o WHERE o.orderInstDt = :orderDate")
    String getMaxOrderCd(@Param("orderDate") LocalDate orderDate);

    List<OrderEntity> findByOrderCd(String orderCd);
}
