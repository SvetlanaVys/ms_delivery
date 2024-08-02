package com.svysk.ms_delivery.adapters.storage.impl;

import com.svysk.ms_delivery.adapters.storage.ProductEntityDao;
import com.svysk.ms_delivery.adapters.storage.mapper.ProductEntityMapper;
import com.svysk.ms_delivery.domain.Product;
import com.svysk.ms_delivery.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductEntityDao productEntityDao;

    private final ProductEntityMapper productEntityMapper;

    @Override
    public List<Product> findAll() {
        return productEntityDao.findAll()
                .stream()
                .map(productEntityMapper::toProduct)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productEntityDao.findById(id)
                .map(productEntityMapper::toProduct);
    }
}
