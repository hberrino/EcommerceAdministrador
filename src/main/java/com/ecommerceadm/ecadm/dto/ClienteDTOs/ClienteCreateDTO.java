package com.ecommerceadm.ecadm.dto.ClienteDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ClienteCreateDTO {
    @NotBlank(message = "El nombre no puede estar vacio")
    @Size (max = 100)
    private String nombre;
    @Email
    @NotBlank(message = "El email no puede estar vacio")
    @Size (max = 100)   
    private String email;
    @NotBlank(message = "El DNI no puede estar vacio")
    @Size (max = 20)
    private String dni;

}
