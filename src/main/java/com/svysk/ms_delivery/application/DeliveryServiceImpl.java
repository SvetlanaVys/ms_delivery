package com.svysk.ms_delivery.application;

import com.svysk.ms_delivery.domain.Delivery;
import com.svysk.ms_delivery.domain.repository.DeliveryRepository;
import com.svysk.ms_delivery.domain.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;

    @Override
    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public Optional<Delivery> findById(Long id) {
        return deliveryRepository.findById(id);
    }

    @Override
    public Optional<Delivery> save(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public void delete(Delivery delivery) {
        deliveryRepository.delete(delivery);
    }

    @Override
    public Optional<Delivery> update(Delivery delivery) {
        return deliveryRepository.update(delivery);
    }
}
