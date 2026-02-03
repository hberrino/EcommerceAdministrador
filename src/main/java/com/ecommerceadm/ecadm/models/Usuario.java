package com.ecommerceadm.ecadm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "usuarios")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY);
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;

    private String role;
    
    
}
