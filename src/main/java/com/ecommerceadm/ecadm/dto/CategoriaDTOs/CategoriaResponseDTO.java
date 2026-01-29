package com.ecommerceadm.ecadm.dto.CategoriaDTOs;
import com.ecommerceadm.ecadm.models.enums.TipoCategoria;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CategoriaResponseDTO {
    
    private Long id;
    private TipoCategoria tipo;
    private String descripcion;
    
}
