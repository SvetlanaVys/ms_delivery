package com.svysk.ms_delivery.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OrderedProduct {

    @JsonIgnore
    private Long id;
    private Integer originalProductId;
    private String productName;
    private Double productPrice;
    private Integer quantity;

}
