package com.ecommerceadm.ecadm.services.producto;

import java.util.List;

import com.ecommerceadm.ecadm.dto.ProductoDTOs.ProductoCreateDTO;
import com.ecommerceadm.ecadm.dto.ProductoDTOs.ProductoResponseDTO;
import com.ecommerceadm.ecadm.dto.ProductoDTOs.ProductoUpdateDTO;
import com.ecommerceadm.ecadm.models.enums.TipoCategoria;

public interface ProductoService {
    
    
    ProductoResponseDTO obtenerProductoPorID (Long id);
    ProductoResponseDTO crearProducto (ProductoCreateDTO producto);
    List<ProductoResponseDTO> obtenerTodosLosProductos ();
    ProductoResponseDTO actualizarProducto (Long id, ProductoUpdateDTO producto);
    void eliminarProducto (Long id);
    ProductoResponseDTO obtenerProductoPorNombre (String nombre);
    List<ProductoResponseDTO> obtenerProductosPorCategoria (TipoCategoria categoria);

    
}
