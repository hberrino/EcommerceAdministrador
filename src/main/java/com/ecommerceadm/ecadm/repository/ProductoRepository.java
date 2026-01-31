package com.ecommerceadm.ecadm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerceadm.ecadm.models.enums.TipoCategoria;

import com.ecommerceadm.ecadm.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long>{

    Optional<Producto> findByNombre(String nombre);
    Optional<Producto> findAllByCategoria (TipoCategoria tipoCategoria);
    
}
