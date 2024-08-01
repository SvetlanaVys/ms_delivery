package com.svysk.ms_delivery.adapters.storage.impl;

import com.svysk.ms_delivery.adapters.storage.DeliveryEntityDao;
import com.svysk.ms_delivery.adapters.storage.mapper.DeliveryEntityMapper;
import com.svysk.ms_delivery.domain.Delivery;
import com.svysk.ms_delivery.domain.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DeliveryRepositoryImpl implements DeliveryRepository {

    private final DeliveryEntityDao deliveryEntityDao;

    private final DeliveryEntityMapper deliveryEntityMapper;

    @Override
    public List<Delivery> findAll() {
        return deliveryEntityDao.findAll()
                .stream()
                .map(deliveryEntityMapper::toDelivery)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Delivery> findById(Long id) {
        return deliveryEntityDao.findById(id)
                .map(deliveryEntityMapper::toDelivery);
    }
}
