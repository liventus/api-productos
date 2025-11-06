package com.lizana.api_productos.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;


@Data
@AllArgsConstructor
@NoArgsConstructor
// (De Lombok)
@Table("products") // <--- ¡Esta es la anotación clave que reemplaza a @Entity!
public class Product {
    @Id

    private Integer id;

    private String nombre;

    private Double precio;

    private Integer stock;

}
