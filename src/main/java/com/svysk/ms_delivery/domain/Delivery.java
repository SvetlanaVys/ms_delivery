package com.svysk.ms_delivery.domain;

import com.svysk.ms_delivery.adapters.storage.entity.ProductEntity;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Delivery {
    Long id;

    String clientName;

    List<ProductEntity> products;

    boolean containsProductWithName(String name){
        return products.stream()
                .anyMatch(product -> Objects.equals(product.getName(), name));
    }
}
