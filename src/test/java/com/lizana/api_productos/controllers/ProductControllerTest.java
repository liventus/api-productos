package com.lizana.api_productos.controllers;

import com.lizana.api_productos.persistence.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureWebTestClient
class ProductControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getAllProducts() {
        webTestClient.get()
                .uri("/products")
                .exchange()
                .expectStatus().isOk();

    }

    @Test
    void getProductById() {

        webTestClient.get().uri("/products/{id}", 2) // Mouse Gamer
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.nombre").isEqualTo("Mouse Gamer")
                .jsonPath("$.precio").isEqualTo(120.5)
                .jsonPath("$.stock").isEqualTo(50);
    }

    @Test
    void createProduct() {
        Product newProduct = new Product(null, "Mouse Gamer", 120.5, 50);

        webTestClient.post()
                .uri("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(newProduct)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.id").isNumber()
                .jsonPath("$.nombre").isEqualTo("Mouse Gamer")
                .jsonPath("$.precio").isEqualTo(120.5)
                .jsonPath("$.stock").isEqualTo(50);
    }

    @Test
    void updateStock() {

        int id = 2;
        int cantidadADescontar = 5;
        webTestClient.patch()
                .uri("/products/{id}/stock", id)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(cantidadADescontar)   // cuerpo: Integer
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.id").isEqualTo(id)
                .jsonPath("$.stock").isEqualTo(5);

    }

    @Test
    void deleteProduct() {
        int id = 2;

        webTestClient.delete()
                .uri("/products/{id}", id)
                .exchange()
                .expectStatus().isOk()
                .expectBody().isEmpty();

    }
}