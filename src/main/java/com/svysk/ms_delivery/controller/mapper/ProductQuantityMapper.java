package com.svysk.ms_delivery.controller.mapper;

import com.svysk.ms_delivery.domain.ProductQuantity;
import com.svysk.openapi.dto.ProductQuantityDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductQuantityMapper {

    ProductQuantityDto toDto(ProductQuantity productQuantity);

    ProductQuantity toProductQuantity(ProductQuantityDto productQuantityDto);
}
