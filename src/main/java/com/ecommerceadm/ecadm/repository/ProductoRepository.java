package com.ecommerceadm.ecadm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerceadm.ecadm.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long>{
    
}
