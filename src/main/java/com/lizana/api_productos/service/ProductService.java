package com.lizana.api_productos.service;


import com.lizana.api_productos.dto.SaveProduct;
import com.lizana.api_productos.persistence.entity.Product;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface ProductService {

    Flux<Product> findAll();

    Mono<Product> findById(Integer id);

    Mono<Product> save(SaveProduct nuevoProduct);

    Mono<Product> updateStock(Integer id, Integer cantidadADescontar);

    Mono<Void> deleteById(Integer id);
}
