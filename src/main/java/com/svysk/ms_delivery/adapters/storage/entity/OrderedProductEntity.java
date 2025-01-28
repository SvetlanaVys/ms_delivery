package com.svysk.ms_delivery.adapters.storage.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "ordered_product")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class OrderedProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordered_product_sequence")
    @SequenceGenerator(name = "ordered_product_sequence", sequenceName = "ordered_product_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "original_product_id")
    private Integer originalProductId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private Double productPrice;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="delivery_id", nullable=false)
    private DeliveryEntity delivery;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedProductEntity that = (OrderedProductEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
