package com.ecommerceadm.ecadm.dto.ClienteDTOs;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ClienteResponseDTO {

    private Long id;
    private String nombre;
    private String email;
    private String dni;
    
}
