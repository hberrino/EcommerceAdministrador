package com.ecommerceadm.ecadm.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceadm.ecadm.dto.PedidoDTOs.PedidoCreateDTO;
import com.ecommerceadm.ecadm.dto.PedidoDTOs.PedidoResponseDTO;
import com.ecommerceadm.ecadm.dto.PedidoDTOs.PedidoUpdateDTO;
import com.ecommerceadm.ecadm.models.enums.EstadoPedido;
import com.ecommerceadm.ecadm.services.pedido.PedidoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
      
    private final PedidoService pedidoService;
    
    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> obtenerPedidoPorID(@PathVariable Long id){
        return ResponseEntity.ok(pedidoService.obtenerPedidoPorID(id));
    }
    @GetMapping()
    public ResponseEntity<List<PedidoResponseDTO>> obtenerTodosLosPedidos(){
        return ResponseEntity.ok(pedidoService.obtenerTodosLosPedidos());
    }
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<PedidoResponseDTO>> obtenerPedidosPorClienteId (@PathVariable Long clienteId){
        return ResponseEntity.ok(pedidoService.obtenerPedidosPorClienteId(clienteId));
    }
    @GetMapping("/direccion/{direccion}")
    public ResponseEntity<List<PedidoResponseDTO>> obtenerPedidosPorDireccion (@PathVariable String direccion){
        return ResponseEntity.ok(pedidoService.obtenerPedidosPorDireccion(direccion));
    }
    @PostMapping()
    public ResponseEntity<PedidoResponseDTO> crearPedido (@RequestBody @Valid PedidoCreateDTO pedidoCreate){
        PedidoResponseDTO creado = pedidoService.crearPedido(pedidoCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido (@PathVariable Long id){
        pedidoService.eliminarPedido(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> actualizarPedido (@PathVariable Long id, @RequestBody PedidoUpdateDTO pedidoUpdate){
        return ResponseEntity.ok(pedidoService.actualizarPedido(id, pedidoUpdate));
    }
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<PedidoResponseDTO>> obtenerPedidosPorEstado (@PathVariable EstadoPedido estado){
        return ResponseEntity.ok(pedidoService.obtenerPedidosPorEstado(estado));
    }

    
    
}
