package com.svysk.ms_delivery.adapters.storage.mapper;

import com.svysk.ms_delivery.adapters.storage.entity.DeliveryEntity;
import com.svysk.ms_delivery.controller.mapper.OrderedProductMapper;
import com.svysk.ms_delivery.domain.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = OrderedProductMapper.class)
public interface DeliveryEntityMapper {


    @Mapping(target = "orderedProducts", source = "orderedProducts")
    Delivery toDelivery(DeliveryEntity delivery);


    @Mapping(target = "orderedProducts", source = "orderedProducts")
    DeliveryEntity toDeliveryEntity(Delivery delivery);
}
