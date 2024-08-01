package com.svysk.ms_delivery.controller;

import com.svysk.ms_delivery.controller.mapper.DeliveryDtoMapper;
import com.svysk.ms_delivery.domain.service.DeliveryService;
import com.svysk.openapi.api.DeliveriesApi;
import com.svysk.openapi.dto.DeliveryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DeliveryController implements DeliveriesApi {

    private final DeliveryService service;

    private final DeliveryDtoMapper deliveryDtoMapper;

    @Override
    public ResponseEntity<DeliveryDto> createDelivery(DeliveryDto deliveryDto) {
        return DeliveriesApi.super.createDelivery(deliveryDto);
    }

    @Override
    public ResponseEntity<Void> deleteDelivery(Integer id) {
        return DeliveriesApi.super.deleteDelivery(id);
    }

    @Override
    public ResponseEntity<List<DeliveryDto>> getDeliveries() {
        return ResponseEntity.ok(service.findAll().stream()
                .map(deliveryDtoMapper::toDeliveryDto)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<DeliveryDto> getDeliveryById(Integer id) {
        return DeliveriesApi.super.getDeliveryById(id);
    }

    @Override
    public ResponseEntity<DeliveryDto> updateDelivery(Integer id, DeliveryDto deliveryDto) {
        return DeliveriesApi.super.updateDelivery(id, deliveryDto);
    }
}
