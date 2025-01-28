package com.svysk.ms_delivery.controller.mapper;

import com.svysk.ms_delivery.domain.Delivery;
import com.svysk.openapi.dto.DeliveryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring", uses = OrderedProductMapper.class)
public interface DeliveryDtoMapper {

    // Define a custom method to convert LocalDateTime to OffsetDateTime
    default OffsetDateTime map(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.atOffset(ZoneOffset.UTC);
    }

    @Mapping(target = "id",source = "id")
    @Mapping(target = "orderedProducts", source = "orderedProducts")
    DeliveryDto toDeliveryDto(Delivery delivery);


    // Define a custom method to convert OffsetDateTime to LocalDateTime
    default LocalDateTime offsetDateTimeToLocalDateTime(OffsetDateTime value) {
        if (value == null) {
            return null;
        }
        return value.toLocalDateTime();  // Convert OffsetDateTime to LocalDateTime
    }

    @Mapping(target = "id",source = "id")
    @Mapping(target = "orderedProducts", source = "orderedProducts")
    Delivery toDelivery(DeliveryDto deliveryDto);
}
