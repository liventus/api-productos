package com.lizana.api_productos.controllers;

import com.lizana.api_productos.dto.SaveProduct;
import com.lizana.api_productos.persistence.entity.Product;
import com.lizana.api_productos.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    //inyección de dependencias a través del constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable Integer id) {
        return productService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> createProduct(@RequestBody SaveProduct nuevoProduct) {
        return productService.save(nuevoProduct);
    }

    @PatchMapping("/{id}/stock")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Product> updateStock(@PathVariable Integer id, @RequestBody Integer cantidadADescontar) {
        return productService.updateStock(id, cantidadADescontar);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteProduct(@PathVariable Integer id) {
        return productService.deleteById(id);
    }



}
