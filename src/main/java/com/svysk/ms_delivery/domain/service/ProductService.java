package com.svysk.ms_delivery.domain.service;

import com.svysk.ms_delivery.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);
}
