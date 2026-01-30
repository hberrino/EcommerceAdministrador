package com.ecommerceadm.ecadm.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

@Table(name = "productos")
@Entity
public class Producto {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)    
        private Long id;

        private String nombre;
        private String descripcion;
        private BigDecimal precio;
        private Integer stock;

        @ManyToOne
        @JoinColumn(name = "categoria_id")
        private Categoria categoria;
        
}
