package com.svysk.ms_delivery.controller;

import com.svysk.ms_delivery.controller.mapper.DeliveryDtoMapper;
import com.svysk.ms_delivery.domain.Delivery;
import com.svysk.ms_delivery.domain.service.DeliveryService;
import com.svysk.openapi.api.DeliveriesApi;
import com.svysk.openapi.dto.DeliveryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DeliveryController implements DeliveriesApi {

    private final DeliveryService service;

    private final DeliveryDtoMapper deliveryDtoMapper;

    @Override
    public ResponseEntity<DeliveryDto> createDelivery(DeliveryDto deliveryDto) {
        Optional<DeliveryDto> newDeliveryDto = service.save(deliveryDtoMapper.toDelivery(deliveryDto))
                .map(deliveryDtoMapper::toDeliveryDto);


        return newDeliveryDto.map(ResponseEntity::ok).orElseGet(() -> (ResponseEntity<DeliveryDto>) ResponseEntity.badRequest());
    }

    @Override
    public ResponseEntity<Void> deleteDelivery(Long id) {
        Optional<Delivery> existingDelivery = this.service.findById(id);

        if (existingDelivery.isPresent()) {
            this.service.delete(existingDelivery.get());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<DeliveryDto>> getDeliveries() {
        return ResponseEntity.ok(service.findAll().stream()
                .map(deliveryDtoMapper::toDeliveryDto)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<DeliveryDto> getDeliveryById(Long id) {
        Optional<Delivery> delivery = service.findById(id);

        return delivery.map(value -> ResponseEntity.ok(deliveryDtoMapper.toDeliveryDto(value))).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @Override
    public ResponseEntity<DeliveryDto> updateDelivery(Long id, DeliveryDto deliveryDto) {
        Optional<Delivery> existingDelivery = this.service.findById(id);

        if(existingDelivery.isPresent()) {
            deliveryDto.setId(id);

            Optional<Delivery> updatedDelivery = service.update(deliveryDtoMapper.toDelivery(deliveryDto));

            if(updatedDelivery.isPresent()) {
                return ResponseEntity.ok(deliveryDtoMapper.toDeliveryDto(updatedDelivery.get()));
            }

        }

        return ResponseEntity.notFound().build();
    }
}
