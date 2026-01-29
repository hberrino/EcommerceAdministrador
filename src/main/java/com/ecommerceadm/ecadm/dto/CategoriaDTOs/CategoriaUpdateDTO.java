package com.ecommerceadm.ecadm.dto.CategoriaDTOs;
import com.ecommerceadm.ecadm.models.enums.TipoCategoria;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter@Setter
public class CategoriaUpdateDTO {

    @Size(max = 50)
    private TipoCategoria tipo;
    @Size(max = 150)
    private String descripcion;

}
