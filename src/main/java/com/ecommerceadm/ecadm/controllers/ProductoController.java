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

import com.ecommerceadm.ecadm.dto.ProductoDTOs.ProductoCreateDTO;
import com.ecommerceadm.ecadm.dto.ProductoDTOs.ProductoResponseDTO;
import com.ecommerceadm.ecadm.dto.ProductoDTOs.ProductoUpdateDTO;
import com.ecommerceadm.ecadm.models.enums.TipoCategoria;
import com.ecommerceadm.ecadm.services.producto.ProductoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;
    
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> obtenerProductoPorID (@PathVariable Long id){
        return ResponseEntity.ok(productoService.obtenerProductoPorID(id));
    }
    @GetMapping()
    public ResponseEntity<List<ProductoResponseDTO>> obtenerTodosLosProductos(){
        return ResponseEntity.ok(productoService.obtenerTodosLosProductos());
    }
    @GetMapping("/nombres/{nombre}")
    public ResponseEntity<ProductoResponseDTO> obtenerProductoPorNombre (@PathVariable String nombre){
        return ResponseEntity.ok(productoService.obtenerProductoPorNombre(nombre));
    }
    @GetMapping("/categorias/{tipoCategoria}")
    public ResponseEntity<List<ProductoResponseDTO>> obtenerProductosPorCategoria (@PathVariable TipoCategoria tipoCategoria){
        return ResponseEntity.ok(productoService.obtenerProductosPorCategoria(tipoCategoria));
    }
    @PostMapping()
    public ResponseEntity<ProductoResponseDTO> crearProducto (@RequestBody @Valid ProductoCreateDTO productoCreate){
        ProductoResponseDTO nuevo = productoService.crearProducto(productoCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizarProducto (@PathVariable Long id, @RequestBody ProductoUpdateDTO productoUpdate){
        return ResponseEntity.ok(productoService.actualizarProducto(id, productoUpdate));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto (@PathVariable Long id){
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}
