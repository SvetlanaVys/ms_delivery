package com.svysk.ms_delivery.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductQuantity {
    private Long id;

    private Long cartId;

    private Product product;

    private Integer productQuantity = 1;

}
