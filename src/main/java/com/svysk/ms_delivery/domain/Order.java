package com.svysk.ms_delivery.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Order {

    Long id;
    String userId;
    Product product;
    Integer productQuantity;
}