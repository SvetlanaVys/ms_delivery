package com.svysk.ms_delivery.domain.repository;

import com.svysk.ms_delivery.domain.Delivery;

import java.util.List;
import java.util.Optional;

public interface DeliveryRepository {

    List<Delivery> findAll();

    Optional<Delivery> findById(Long id);

    Optional<Delivery> save(Delivery delivery);

    void delete(Delivery delivery);
}
