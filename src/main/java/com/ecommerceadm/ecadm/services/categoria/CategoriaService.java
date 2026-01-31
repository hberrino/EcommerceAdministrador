package com.ecommerceadm.ecadm.services.categoria;

import java.util.List;

import com.ecommerceadm.ecadm.dto.CategoriaDTOs.CategoriaCreateDTO;
import com.ecommerceadm.ecadm.dto.CategoriaDTOs.CategoriaResponseDTO;
import com.ecommerceadm.ecadm.dto.CategoriaDTOs.CategoriaUpdateDTO;
import com.ecommerceadm.ecadm.models.enums.TipoCategoria;


public interface CategoriaService {

    List<CategoriaResponseDTO> obtenerTodasCategorias();
    List<TipoCategoria> obtenerTiposCategoria();
    CategoriaResponseDTO crearCategoria(CategoriaCreateDTO categoriaCreate);
    CategoriaResponseDTO obtenerCategoriaPorID (Long id);
    CategoriaResponseDTO actualizarCategoria (Long id, CategoriaUpdateDTO categoriaUpdate);
    void eliminarCategoria (Long id);

    
}
