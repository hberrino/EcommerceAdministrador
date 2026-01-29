package com.ecommerceadm.ecadm.dto.PedidoDTOs;


import com.ecommerceadm.ecadm.models.enums.EstadoPedido;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter  
public class PedidoUpdateDTO {

    @Size (max = 100)
    private String direccion;
    private EstadoPedido estado;
 
}
