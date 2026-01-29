package com.ecommerceadm.ecadm.dto.CategoriaDTOs;

import com.ecommerceadm.ecadm.models.enums.TipoCategoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CategoriaCreateDTO {

    @NotNull (message = "El tipo de categoria no puede estar vacio")
    private TipoCategoria tipo;
    @NotBlank (message = "La descripcion no puede estar vacia") 
    @Size (max = 150)
    private String descripcion;

}