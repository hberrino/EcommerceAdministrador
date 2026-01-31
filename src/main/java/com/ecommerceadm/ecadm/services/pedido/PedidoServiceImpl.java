package com.ecommerceadm.ecadm.services.pedido;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerceadm.ecadm.dto.PedidoDTOs.PedidoCreateDTO;
import com.ecommerceadm.ecadm.dto.PedidoDTOs.PedidoResponseDTO;
import com.ecommerceadm.ecadm.dto.PedidoDTOs.PedidoUpdateDTO;
import com.ecommerceadm.ecadm.models.Pedido;
import com.ecommerceadm.ecadm.models.enums.EstadoPedido;
import com.ecommerceadm.ecadm.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    private PedidoResponseDTO pedidoToDTO (Pedido pedido){
        PedidoResponseDTO dto = new PedidoResponseDTO();
        dto.setId(pedido.getId());
        dto.setDireccion(pedido.getDireccion());
        dto.setTotal(pedido.getTotal());
        dto.setEstado(pedido.getEstado());
        return dto;
    }
    @Override
    public PedidoResponseDTO obtenerPedidoPorID(Long id){
        Pedido pedido = pedidoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Pedido no encontrado"));
        return pedidoToDTO(pedido);
    }
    @Override
    public List<PedidoResponseDTO> obtenerTodosLosPedidos(){
        return pedidoRepository.findAll().stream().map(this::pedidoToDTO).toList();
    }
    @Override 
    public PedidoResponseDTO crearPedido (PedidoCreateDTO pedido){
        Pedido dto = new Pedido();
        dto.setDireccion(pedido.getDireccion());
        dto.setEstado(pedido.getEstado());
        Pedido pedidonuevo = pedidoRepository.save(dto);
        return pedidoToDTO(pedidonuevo);
    }
    @Override
    public void eliminarPedido (Long id){
        Pedido p = pedidoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException ("Pedido no encontrado"));
        pedidoRepository.delete(p);
    }
    @Override
    public PedidoResponseDTO actualizarPedido (Long id, PedidoUpdateDTO pedidoUpdate){
        Pedido pedido = pedidoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Pedido no encontrado"));
        if(pedidoUpdate.getDireccion()!=null){
            pedido.setDireccion(pedidoUpdate.getDireccion());
        }
        if(pedidoUpdate.getEstado()!=null){
            pedido.setEstado(pedidoUpdate.getEstado());
        }
        Pedido pedidonuevo = pedidoRepository.save(pedido);
        return pedidoToDTO(pedidonuevo);
    }
    @Override
    public List<PedidoResponseDTO> obtenerPedidosPorEstado (EstadoPedido estado){
        return pedidoRepository.findAllByEstado(estado)
        .stream().map(this::pedidoToDTO).toList();
    }
    @Override
    public List<PedidoResponseDTO> obtenerPedidosPorDireccion (String direccion){
        return pedidoRepository.findAllByDireccion(direccion)
        .stream().map(this::pedidoToDTO).toList();
    }
    @Override
    public List<PedidoResponseDTO> obtenerPedidosPorClienteId (Long clienteId){
        return pedidoRepository.findAllByClienteId(clienteId)
        .stream().map(this::pedidoToDTO).toList();
    }



    
}
