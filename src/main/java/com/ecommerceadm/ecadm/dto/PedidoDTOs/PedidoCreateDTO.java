package com.ecommerceadm.ecadm.dto.PedidoDTOs;


import com.ecommerceadm.ecadm.models.enums.EstadoPedido;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PedidoCreateDTO {
    
    @NotBlank (message = "La direccion no puede estar vacia")
    @Size (max = 100)
    private String direccion;
    @NotNull (message = "El estado no puede estar vacio")
    private EstadoPedido estado;
    
    
}
