package com.svysk.ms_delivery.domain.service;

import com.svysk.ms_delivery.domain.Delivery;

import java.util.List;
import java.util.Optional;

public interface DeliveryService {
    List<Delivery> findAll();

    Optional<Delivery> findById(Long id);
}
