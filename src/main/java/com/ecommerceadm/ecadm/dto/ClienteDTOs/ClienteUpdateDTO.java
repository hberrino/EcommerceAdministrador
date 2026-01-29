package com.ecommerceadm.ecadm.dto.ClienteDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ClienteUpdateDTO {
    @Size (max = 100)
    private String nombre;
    @Size (max = 100)
    @Email
    private String email;
    @Size (max = 20)
    private String dni;
    
}
