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

import com.ecommerceadm.ecadm.dto.CategoriaDTOs.CategoriaCreateDTO;
import com.ecommerceadm.ecadm.dto.CategoriaDTOs.CategoriaResponseDTO;
import com.ecommerceadm.ecadm.dto.CategoriaDTOs.CategoriaUpdateDTO;
import com.ecommerceadm.ecadm.models.enums.TipoCategoria;
import com.ecommerceadm.ecadm.services.categoria.CategoriaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {
    
    private final CategoriaService categoriaService;

    @GetMapping()
    public ResponseEntity<List<CategoriaResponseDTO>> listarCategorias (){
        return ResponseEntity.ok(categoriaService.obtenerTodasCategorias());
    }
    @GetMapping("/tipos")
    public ResponseEntity<List<TipoCategoria>> obtenerTipoCategorias (){
        return ResponseEntity.ok(categoriaService.obtenerTiposCategoria());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> categoriaPorId (@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.obtenerCategoriaPorID(id));
    }
    @PostMapping()
    public ResponseEntity<CategoriaResponseDTO> crearCategoria (@RequestBody @Valid CategoriaCreateDTO categoriacreate){
        CategoriaResponseDTO creado = categoriaService.crearCategoria(categoriacreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> actualizarCategoria (@PathVariable Long id, @RequestBody CategoriaUpdateDTO categoriaUpdate){
        return ResponseEntity.ok(categoriaService.actualizarCategoria(id, categoriaUpdate));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria (@PathVariable Long id){
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }

}
