package com.ecommerceadm.ecadm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerceadm.ecadm.models.Pedido;
import com.ecommerceadm.ecadm.models.enums.EstadoPedido;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Long>  {
    List<Pedido> findAllByEstado(EstadoPedido estado);
    List<Pedido> findAllByDireccion (String direccion);
    List<Pedido> findAllByClienteId (Long clienteId);
}
