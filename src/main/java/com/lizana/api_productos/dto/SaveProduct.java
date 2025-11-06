package com.lizana.api_productos.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveProduct implements Serializable {



    private String nombre;
    private Double precio;
    private Integer stock;


}
