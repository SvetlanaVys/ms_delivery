package com.svysk.ms_delivery.controller.mapper;

import com.svysk.ms_delivery.adapters.storage.entity.OrderedProductEntity;
import com.svysk.ms_delivery.domain.OrderedProduct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderedProductMapper {

    OrderedProduct toOrderedProduct(OrderedProductEntity productQuantity);

    OrderedProductEntity toOrderedProductEntity(OrderedProduct productQuantityDto);
}
