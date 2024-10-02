package com.svysk.ms_delivery.controller.mapper;

import com.svysk.ms_delivery.domain.Delivery;
import com.svysk.openapi.dto.DeliveryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring", uses = ProductQuantityMapper.class)
public interface DeliveryDtoMapper {

    @Mapping(target = "id",source = "id")
    @Mapping(target = "clientName", source = "clientName")
    @Mapping(target = "productQuantities", source = "productQuantities")
    DeliveryDto toDeliveryDto(Delivery delivery);

    @Mapping(target = "id",source = "id")
    @Mapping(target = "clientName", source = "clientName")
    @Mapping(target = "productQuantities", source = "productQuantities")
    Delivery toDelivery(DeliveryDto deliveryDto);
}
