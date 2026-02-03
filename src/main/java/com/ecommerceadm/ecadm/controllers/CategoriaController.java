package com.ecommerceadm.ecadm.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    // 🌍 PÚBLICO
    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> listarCategorias() {
        return ResponseEntity.ok(
            categoriaService.obtenerTodasCategorias()
        );
    }

    // 🌍 PÚBLICO
    @GetMapping("/tipo")
    public ResponseEntity<List<TipoCategoria>> obtenerTipoCategorias() {
        return ResponseEntity.ok(
            categoriaService.obtenerTiposCategoria()
        );
    }

    // 🌍 PÚBLICO
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> categoriaPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
            categoriaService.obtenerCategoriaPorID(id)
        );
    }

    // 🔒 SOLO ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> crearCategoria(
            @RequestBody @Valid CategoriaCreateDTO dto) {

        CategoriaResponseDTO creado =
                categoriaService.crearCategoria(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // 🔒 SOLO ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> actualizarCategoria(
            @PathVariable Long id,
            @RequestBody @Valid CategoriaUpdateDTO dto) {

        return ResponseEntity.ok(
            categoriaService.actualizarCategoria(id, dto)
        );
    }

    // 🔒 SOLO ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(
            @PathVariable Long id) {

        categoriaService.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
