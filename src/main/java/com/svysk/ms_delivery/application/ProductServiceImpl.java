package com.svysk.ms_delivery.application;

import com.svysk.ms_delivery.domain.Product;
import com.svysk.ms_delivery.domain.repository.ProductRepository;
import com.svysk.ms_delivery.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
            return productRepository.findById(id);
    }
}
