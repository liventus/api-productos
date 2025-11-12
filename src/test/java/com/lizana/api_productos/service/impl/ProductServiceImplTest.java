package com.lizana.api_productos.service.impl;

import com.lizana.api_productos.persistence.entity.Product;
import com.lizana.api_productos.persistence.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    private ProductServiceImpl productService;
    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setup(){
        productService = new ProductServiceImpl(productRepository);
    }
    @Test
    void findAll_caseOK() {
        Mockito.when(productRepository.findAll()).thenReturn(Flux.just(new Product()));
        productService.findAll();
    }
}