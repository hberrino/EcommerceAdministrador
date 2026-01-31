package com.ecommerceadm.ecadm.services.producto;

import java.util.List;

import org.springframework.stereotype.Service;
import com.ecommerceadm.ecadm.repository.ProductoRepository;
import com.ecommerceadm.ecadm.models.Producto;
import com.ecommerceadm.ecadm.dto.ProductoDTOs.ProductoResponseDTO;
import com.ecommerceadm.ecadm.dto.ProductoDTOs.ProductoCreateDTO;
import com.ecommerceadm.ecadm.dto.ProductoDTOs.ProductoUpdateDTO;
import com.ecommerceadm.ecadm.models.enums.TipoCategoria;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService{

    private final ProductoRepository productoRepository;

    private ProductoResponseDTO productoToDTO(Producto producto){
        ProductoResponseDTO p = new ProductoResponseDTO();
        p.setId(producto.getId());
        p.setNombre(producto.getNombre());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
        p.setStock(producto.getStock());
        return p;
    }
    @Override
    public ProductoResponseDTO crearProducto (ProductoCreateDTO productoCreate){
        Producto prod = new Producto ();
        prod.setNombre(productoCreate.getNombre());
        prod.setDescripcion(productoCreate.getDescripcion());
        prod.setPrecio(productoCreate.getPrecio());
        prod.setStock(productoCreate.getStock());
        Producto nuevo = productoRepository.save(prod);
        return productoToDTO(nuevo);
    }
    @Override
    public void eliminarProducto (Long id){
        productoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Producto no encontrado"));
        productoRepository.deleteById(id);
    }
    @Override
    public ProductoResponseDTO obtenerProductoPorNombre(String nombre){
        Producto p = productoRepository.findByNombre(nombre)
         .orElseThrow(()-> new RuntimeException("Producto no encontrado"));
         return productoToDTO(p);
    }
    @Override
    public ProductoResponseDTO obtenerProductoPorID(Long id) {
        Producto p = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return productoToDTO(p);
    }
    @Override
    public List<ProductoResponseDTO> obtenerTodosLosProductos (){
        return productoRepository.findAll()
        .stream()
        .map(this::productoToDTO)
        .toList();
    }
    @Override
    public ProductoResponseDTO actualizarProducto (Long id, ProductoUpdateDTO productoUpdate){
        Producto p = productoRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Producto no encontrado"));
        if(productoUpdate.getNombre()!=null){
            p.setNombre(productoUpdate.getNombre());
        }
        if(productoUpdate.getDescripcion()!=null){
            p.setDescripcion(productoUpdate.getDescripcion());
        }
        if(productoUpdate.getStock()!=null){
            p.setStock(productoUpdate.getStock());
        }
        if(productoUpdate.getPrecio()!=null){
            p.setPrecio(productoUpdate.getPrecio());
        }
        Producto nuevo = productoRepository.save(p);
        return productoToDTO(nuevo);
    }
    @Override
    public List<ProductoResponseDTO> obtenerProductosPorCategoria (TipoCategoria tipoCategoria){
        return productoRepository.findAllByCategoria(tipoCategoria)
        .stream()
        .map(this::productoToDTO)
        .toList();
    }
    
    
}
