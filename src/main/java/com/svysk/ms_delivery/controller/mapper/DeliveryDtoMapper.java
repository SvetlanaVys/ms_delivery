package com.svysk.ms_delivery.controller.mapper;

import com.svysk.ms_delivery.domain.Delivery;
import com.svysk.openapi.dto.DeliveryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface DeliveryDtoMapper {

    @Mapping(target = "id",source = "id")
    @Mapping(target = "clientName", source = "clientName", qualifiedByName = "myMapping")
    DeliveryDto toDeliveryDto(Delivery delivery);

    @Named("myMapping")
    default String myMapping(String clientName){
        return "product" + clientName;
    }
}
