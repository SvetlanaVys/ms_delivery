package com.svysk.ms_delivery.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Data
public class Delivery {
    private Long id;

    private String clientName;

    private List<ProductQuantity> productQuantities;

    private LocalDateTime createdDate;

    boolean containsProductWithName(String name){
        return productQuantities.stream()
                .anyMatch(productQ -> Objects.equals(productQ.getProduct().getName(), name));
    }
}
