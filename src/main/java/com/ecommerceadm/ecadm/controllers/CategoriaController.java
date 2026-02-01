package com.ecommerceadm.ecadm.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceadm.ecadm.dto.CategoriaDTOs.CategoriaResponseDTO;
import com.ecommerceadm.ecadm.services.categoria.CategoriaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {
    
    private final CategoriaService categoriaService;

    @GetMapping()
    public List<CategoriaResponseDTO> listarCategorias (){
        return categoriaService.obtenerTodasCategorias();
    }
    @GetMapping("/{id}")
    public CategoriaResponseDTO categoriaPorId (@PathVariable Long id){
        return categoriaService.obtenerCategoriaPorID(id);
    }
    
}
