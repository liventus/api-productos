package com.lizana.api_productos.persistence.repository;

import com.lizana.api_productos.persistence.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import org.springframework.data.domain.Pageable;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {



}