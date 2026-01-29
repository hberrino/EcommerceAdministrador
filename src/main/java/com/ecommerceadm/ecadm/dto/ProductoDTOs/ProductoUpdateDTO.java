package com.ecommerceadm.ecadm.dto.ProductoDTOs;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProductoUpdateDTO {


    @Size (max = 50)
    private String nombre;
    @Size (max = 150)
    private String descripcion;
    @DecimalMin("0.0")
    private BigDecimal precio;
    @PositiveOrZero
    private Integer stock;
    
}
