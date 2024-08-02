package com.svysk.ms_delivery.controller;

import com.svysk.ms_delivery.controller.mapper.ProductDtoMapper;
import com.svysk.ms_delivery.domain.service.ProductService;
import com.svysk.openapi.api.ProductsApi;
import com.svysk.openapi.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductsApi {

    private final ProductService service;

    private final ProductDtoMapper productDtoMapper;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ProductsApi.super.getRequest();
    }

    @Override
    public ResponseEntity<ProductDto> createProduct(ProductDto productDto) {
        return ProductsApi.super.createProduct(productDto);
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Integer id) {
        return ProductsApi.super.deleteProduct(id);
    }

    @Override
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(service.findAll().stream()
                .map(productDtoMapper::toProductDto)
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<ProductDto> getProductById(Integer id) {
        return ProductsApi.super.getProductById(id);
    }

    @Override
    public ResponseEntity<ProductDto> updateProduct(Integer id, ProductDto productDto) {
        return ProductsApi.super.updateProduct(id, productDto);
    }
}
