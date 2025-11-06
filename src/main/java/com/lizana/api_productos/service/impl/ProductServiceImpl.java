package com.lizana.api_productos.service.impl;

import com.lizana.api_productos.dto.SaveProduct;
import com.lizana.api_productos.exception.ObjectNotFoundException;
import com.lizana.api_productos.persistence.entity.Product;
import com.lizana.api_productos.persistence.repository.ProductRepository;
import com.lizana.api_productos.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> findById(Integer id) {
        return productRepository.findById(id)
                .switchIfEmpty(Mono.error(
                        new ObjectNotFoundException("Producto con ID " + id + " no encontrado")
                ));
    }

    @Override
    public Mono<Product> save(SaveProduct nuevoProduct) {
        Product product = new Product();
        product.setNombre(nuevoProduct.getNombre());
        product.setPrecio(nuevoProduct.getPrecio());
        product.setStock(nuevoProduct.getStock());
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> updateStock(Integer id, Integer stock) {
        return productRepository.findById(id)
                .switchIfEmpty(Mono.error(
                        new ObjectNotFoundException("Producto con ID " + id + " no encontrado")
                ))
                .flatMap(producto -> {
                    producto.setStock(stock);
                    return productRepository.save(producto);
                });
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return productRepository.deleteById(id);
    }
}
