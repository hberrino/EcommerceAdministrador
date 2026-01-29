package com.ecommerceadm.ecadm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerceadm.ecadm.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Long>  {
    
}
