package com.ecommerceadm.ecadm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerceadm.ecadm.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long>  {
    
}
