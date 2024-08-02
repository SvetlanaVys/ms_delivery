package com.svysk.ms_delivery.adapters.storage.mapper;

import com.svysk.ms_delivery.adapters.storage.entity.ProductEntity;
import com.svysk.ms_delivery.domain.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {
    Product toProduct(ProductEntity product);
}
