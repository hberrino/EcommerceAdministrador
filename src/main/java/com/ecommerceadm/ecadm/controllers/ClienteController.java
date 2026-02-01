package com.ecommerceadm.ecadm.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ecommerceadm.ecadm.dto.ClienteDTOs.ClienteCreateDTO;
import com.ecommerceadm.ecadm.dto.ClienteDTOs.ClienteResponseDTO;
import com.ecommerceadm.ecadm.dto.ClienteDTOs.ClienteUpdateDTO;
import com.ecommerceadm.ecadm.services.cliente.ClienteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
    
    private final ClienteService clienteService;

    @GetMapping()
    public ResponseEntity<List<ClienteResponseDTO>> listarClientes (){
        return ResponseEntity.ok(clienteService.ListarClientes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> obtenerClientePorId (@PathVariable Long id){
        return ResponseEntity.ok(clienteService.obtenerClientePorID(id));
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<ClienteResponseDTO> obtenerClientePorEmail (@PathVariable String email){
        return ResponseEntity.ok(clienteService.obtenerClientePorEmail(email));
    }
    @GetMapping("/dni/{dni}")
    public ResponseEntity<ClienteResponseDTO> obtenerClientePorDNI (@PathVariable String dni){
        return ResponseEntity.ok(clienteService.obtenerClientePorDNI(dni));
    }
    @PostMapping()
    public ResponseEntity<ClienteResponseDTO> crearCliente (@RequestBody @Valid ClienteCreateDTO clienteCreate){
        ClienteResponseDTO creado = clienteService.crearCliente(clienteCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente (@PathVariable Long id){
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> actualizaCliente (@PathVariable Long id, @RequestBody ClienteUpdateDTO clienteUpdate){
        return ResponseEntity.ok(clienteService.actualizarCliente(id, clienteUpdate));
    }

}
