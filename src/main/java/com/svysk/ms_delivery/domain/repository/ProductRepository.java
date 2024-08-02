package com.svysk.ms_delivery.domain.repository;

import com.svysk.ms_delivery.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();

    Optional<Product> findById(Long id);
}
