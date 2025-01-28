package com.svysk.ms_delivery.adapters.storage;

import com.svysk.ms_delivery.adapters.storage.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryEntityDao extends JpaRepository<DeliveryEntity, Long> {

    @Query(value = "SELECT d FROM DeliveryEntity d LEFT JOIN FETCH d.orderedProducts")
    List<DeliveryEntity> findAllWithOrderedProducts();
}
