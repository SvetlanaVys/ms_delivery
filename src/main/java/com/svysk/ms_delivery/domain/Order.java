package com.svysk.ms_delivery.domain;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
public class Order {

    private Long id;
    private String userId;
    private LocalDateTime createdDate;

    private List<OrderedProduct> orderedProducts;
}