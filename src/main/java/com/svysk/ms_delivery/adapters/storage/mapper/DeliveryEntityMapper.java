package com.svysk.ms_delivery.adapters.storage.mapper;

import com.svysk.ms_delivery.adapters.storage.entity.DeliveryEntity;
import com.svysk.ms_delivery.domain.Delivery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryEntityMapper {

    Delivery toDelivery(DeliveryEntity delivery);

    DeliveryEntity toDeliveryEntity(Delivery delivery);
}
