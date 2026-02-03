package com.ecommerceadm.ecadm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceadm.ecadm.models.Usuario;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
    boolean existsByUsername(String username);
}
