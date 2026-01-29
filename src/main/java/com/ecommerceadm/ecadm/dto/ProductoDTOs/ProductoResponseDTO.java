package com.ecommerceadm.ecadm.dto.ProductoDTOs;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ProductoResponseDTO {
    
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    
}
