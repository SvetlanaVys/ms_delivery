package com.svysk.ms_delivery.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.svysk.ms_delivery.domain.Delivery;
import com.svysk.ms_delivery.domain.Order;
import com.svysk.ms_delivery.domain.ProductQuantity;
import com.svysk.ms_delivery.domain.repository.DeliveryRepository;
import com.svysk.ms_delivery.domain.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return deliveryRepository.update(delivery);
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
        List<Order> orders = objectMapper.readValue(orderMessage, new TypeReference<>() { });
        List<ProductQuantity> productQuantityList = new ArrayList<>();

        for(Order orderItem : orders) {
            productQuantityList.add(ProductQuantity.builder()
                    .cartId(orderItem.getId())
                    .product(orderItem.getProduct())
                    .productQuantity(orderItem.getProductQuantity())
                    .build());
        }

        Delivery delivery = new Delivery();
        delivery.setClientName(orders.get(0).getUserId());
        delivery.setProductQuantities(productQuantityList);
        delivery.setCreatedDate(LocalDateTime.now());

        deliveryRepository.save(delivery);

        System.out.println("Received message: " + orders);
        System.out.println("Delivery: " + delivery);
    }
}
