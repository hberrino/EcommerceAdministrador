package com.ecommerceadm.ecadm.models;

import java.math.BigDecimal;

import com.ecommerceadm.ecadm.models.enums.EstadoPedido;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

@Entity
public class Pedido {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
  
}
