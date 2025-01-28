package com.svysk.ms_delivery.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.svysk.ms_delivery.domain.Delivery;
import com.svysk.ms_delivery.domain.Order;
import com.svysk.ms_delivery.domain.repository.DeliveryRepository;
import com.svysk.ms_delivery.domain.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.svysk.ms_delivery.config.KafkaTopicConfig.ORDER_REQUEST_TOPIC;

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
        return deliveryRepository.save(delivery);
    }

    @KafkaListener(
            topics = {
                    ORDER_REQUEST_TOPIC
            }
    )
    @SneakyThrows
    @Override
    public void receiveOrder(@Payload String orderMessage) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        Order order = objectMapper.readValue(orderMessage, new TypeReference<>() { });

        Delivery delivery = new Delivery();
        delivery.setUserId(order.getUserId());
        delivery.setOriginalOrderId(order.getId());
        delivery.setOrderedProducts(order.getOrderedProducts());
        delivery.setEstimatedDeliveryDate(order.getCreatedDate().plusDays(10));
        delivery.setCreatedDate(LocalDateTime.now());

        String trackingNumber = "ABC" + order.getId() + UUID.randomUUID().toString().substring(0, 8);
        delivery.setTrackingNumber(trackingNumber);

        deliveryRepository.save(delivery);

    }
}
