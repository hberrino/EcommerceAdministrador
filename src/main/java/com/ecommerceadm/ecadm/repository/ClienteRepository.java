package com.ecommerceadm.ecadm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerceadm.ecadm.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByDni (String dni);
    Optional<Cliente> findByEmail (String email);
}
