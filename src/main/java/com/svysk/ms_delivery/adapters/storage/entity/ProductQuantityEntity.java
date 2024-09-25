package com.svysk.ms_delivery.adapters.storage.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "product_quantity")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ProductQuantityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cart_id")
    private Long cartId;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name="delivery_id", nullable=false)
    private DeliveryEntity delivery;

    @Column(name = "product_quantity")
    private Integer productQuantity = 1;

    public ProductQuantityEntity(Long cartId, ProductEntity product, Integer productQuantity) {
        this.cartId = cartId;
        this.product = product;
        this.productQuantity = productQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductQuantityEntity that = (ProductQuantityEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
