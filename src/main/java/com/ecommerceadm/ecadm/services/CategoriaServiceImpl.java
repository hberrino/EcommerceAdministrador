package com.ecommerceadm.ecadm.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerceadm.ecadm.dto.CategoriaDTOs.CategoriaCreateDTO;
import com.ecommerceadm.ecadm.dto.CategoriaDTOs.CategoriaResponseDTO;
import com.ecommerceadm.ecadm.dto.CategoriaDTOs.CategoriaUpdateDTO;
import com.ecommerceadm.ecadm.models.Categoria;
import com.ecommerceadm.ecadm.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;


    private CategoriaResponseDTO categoriaToDTO (Categoria categoria) {
        CategoriaResponseDTO dto = new CategoriaResponseDTO();
        dto.setId(categoria.getId());
        dto.setTipo(categoria.getTipo());
        dto.setDescripcion(categoria.getDescripcion());
        return dto;
    }
    @Override
    public List<String> obtenerTiposCategoria() {
        return categoriaRepository.findAllTiposCategoria();
    }
    @Override
    public List<CategoriaResponseDTO> obtenerTodasCategorias() {
        return categoriaRepository.findAll()
        .stream().map(this::categoriaToDTO).toList();
    }
    @Override
    public CategoriaResponseDTO crearCategoria (CategoriaCreateDTO categoriaCreate){
        Categoria dto = new Categoria();
        dto.setDescripcion(categoriaCreate.getDescripcion());
        dto.setTipo(categoriaCreate.getTipo());
        Categoria nuevaCategoria = categoriaRepository.save(dto);
        return categoriaToDTO(nuevaCategoria);
    }
    @Override
    public CategoriaResponseDTO obtenerCategoriaPorID (Long id) {
        Categoria categoria = categoriaRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Categoria no encontrada"));
        return categoriaToDTO(categoria);
    }
    @Override
    public CategoriaResponseDTO actualizarCategoria (Long id, CategoriaUpdateDTO categoriaUpdate){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(()-> new RuntimeException("Categoria no encontrada"));
        if(categoriaUpdate.getDescripcion() != null){
            categoria.setDescripcion(categoriaUpdate.getDescripcion());
        }
        if (categoriaUpdate.getTipo() != null){
            categoria.setTipo(categoriaUpdate.getTipo());
        }
        Categoria categoriaActualizada = categoriaRepository.save(categoria);
        return categoriaToDTO(categoriaActualizada);
    }
    @Override
    public void eliminarCategoria (Long id){
        Categoria categoria = categoriaRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Categoria no encontrada"));
        categoriaRepository.delete(categoria);
    }   
   
}
