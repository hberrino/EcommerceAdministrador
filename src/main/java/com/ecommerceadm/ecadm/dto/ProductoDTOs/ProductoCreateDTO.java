package com.ecommerceadm.ecadm.dto.ProductoDTOs;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter@Setter
public class ProductoCreateDTO {
    
    @NotBlank (message = "El nombre no puede estar vacio")
    @Size (max = 50)
    private String nombre;
    @NotBlank (message = "La descripcion no puede estar vacia")
    @Size (max = 150)
    private String descripcion;
    @NotNull (message = "El precio no puede estar vacio")
    @DecimalMin("0.0")
    private BigDecimal precio;
    @NotNull (message = "El stock no puede estar vacio")
    @DecimalMin("0")
    private Integer stock;
    
}
