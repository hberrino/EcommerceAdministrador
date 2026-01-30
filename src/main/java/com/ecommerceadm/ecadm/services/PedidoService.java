package com.ecommerceadm.ecadm.services;

import java.util.List;

import com.ecommerceadm.ecadm.dto.PedidoDTOs.PedidoCreateDTO;
import com.ecommerceadm.ecadm.dto.PedidoDTOs.PedidoResponseDTO;
import com.ecommerceadm.ecadm.dto.PedidoDTOs.PedidoUpdateDTO;
import com.ecommerceadm.ecadm.models.enums.EstadoPedido;


public interface PedidoService {


    PedidoResponseDTO obtenerPedidoPorID (Long id);
    List<PedidoResponseDTO> obtenerPedidosPorClienteID (Long clienteId);
    List<PedidoResponseDTO> obtenerPedidosPorDireccion (String direccion);
    List<PedidoResponseDTO> obtenerTodosLosPedidos ();
    PedidoResponseDTO crearPedido (PedidoCreateDTO pedidoCreate);
    void eliminarPedido (Long id);
    PedidoResponseDTO actualizarPedido (Long id, PedidoUpdateDTO pedidoUpdate);
    List<PedidoResponseDTO> obtenerPedidosPorEstado (EstadoPedido estado);


    
}
