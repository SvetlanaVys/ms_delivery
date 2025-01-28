package com.svysk.ms_delivery.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
public class Delivery {

    private Long id;

    private String userId;

    private Long originalOrderId;

    private List<OrderedProduct> orderedProducts;

    private LocalDateTime createdDate;

    private LocalDateTime estimatedDeliveryDate;

    private LocalDateTime actualDeliveryDate;

    private String trackingNumber;

    boolean containsProductWithName(String name){
        return orderedProducts.stream()
                .anyMatch(op -> Objects.equals(op.getProductName(), name));
    }
}
