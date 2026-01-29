package com.ecommerceadm.ecadm.dto.PedidoDTOs;

import java.math.BigDecimal;
import com.ecommerceadm.ecadm.models.enums.EstadoPedido;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PedidoResponseDTO {

    private Long id;
    private String direccion;
    private BigDecimal total;
    private EstadoPedido estado;
    
}
