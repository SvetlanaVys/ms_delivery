package com.svysk.ms_delivery.controller.mapper;

import com.svysk.ms_delivery.domain.Delivery;
import com.svysk.ms_delivery.domain.Product;
import com.svysk.ms_delivery.domain.ProductQuantity;
import com.svysk.openapi.dto.DeliveryDto;
import com.svysk.openapi.dto.ProductDto;
import com.svysk.openapi.dto.ProductQuantityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DeliveryDtoMapper {

    @Mapping(target = "id",source = "id")
    @Mapping(target = "clientName", source = "clientName")
    @Mapping(target = "productQuantities", source = "productQuantities", qualifiedByName = "mapProductsDto")
    DeliveryDto toDeliveryDto(Delivery delivery);

    @Mapping(target = "id",source = "id")
    @Mapping(target = "clientName", source = "clientName")
    @Mapping(target = "productQuantities", source = "productQuantities", qualifiedByName = "mapProducts")
    Delivery toDelivery(DeliveryDto deliveryDto);



    @Named("mapProductsDto")
    default List<ProductQuantityDto> mapProductsDto(List<ProductQuantity> productQuantities) {
        List<ProductQuantityDto> productQuantityDtos = new ArrayList<>();

        for (ProductQuantity productQuantity : productQuantities) {
            ProductQuantityDto productQuantityDto = new ProductQuantityDto();
            productQuantityDto.setId(productQuantity.getId());
            productQuantityDto.setCartId(productQuantity.getCartId());

            ProductDto productDto = new ProductDto();
            productDto.setId(productQuantity.getProduct().getId());
            productDto.setName(productQuantity.getProduct().getName());
            productDto.setPrice(productQuantity.getProduct().getPrice());

            productQuantityDto.setProduct(productDto);
            productQuantityDto.setProductQuantity(productQuantity.getProductQuantity());
            productQuantityDtos.add(productQuantityDto);
        }

        return productQuantityDtos;
    }

    @Named("mapProducts")
    default List<ProductQuantity> mapProducts(List<ProductQuantityDto> productQuantityDtos) {
        List<ProductQuantity> productQuantities = new ArrayList<>();

        for (ProductQuantityDto productQuantityDto : productQuantityDtos) {

            Product product = new Product();
            product.setId(productQuantityDto.getProduct().getId());
            product.setName(productQuantityDto.getProduct().getName());
            product.setPrice(productQuantityDto.getProduct().getPrice());

            ProductQuantity.builder()
                    .id(productQuantityDto.getId())
                    .cartId(productQuantityDto.getCartId())
                    .product(product)
                    .productQuantity(productQuantityDto.getProductQuantity()).build();
        }

        return productQuantities;
    }
}
