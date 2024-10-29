package com.svysk.ms_delivery.adapters.storage;

import com.svysk.ms_delivery.adapters.storage.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryEntityDao extends JpaRepository<DeliveryEntity, Long> {
}
