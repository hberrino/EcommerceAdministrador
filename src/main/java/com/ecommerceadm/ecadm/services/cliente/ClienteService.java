package com.ecommerceadm.ecadm.services.cliente;

import java.util.List;

import com.ecommerceadm.ecadm.dto.ClienteDTOs.ClienteCreateDTO;
import com.ecommerceadm.ecadm.dto.ClienteDTOs.ClienteResponseDTO;
import com.ecommerceadm.ecadm.dto.ClienteDTOs.ClienteUpdateDTO;

public interface ClienteService {

      ClienteResponseDTO obtenerClientePorID (Long id);
      ClienteResponseDTO obtenerClientePorDNI (String dni);
      ClienteResponseDTO obtenerClientePorEmail (String email);
      ClienteResponseDTO crearCliente (ClienteCreateDTO clienteCreate);
      void eliminarCliente (Long id);
      ClienteResponseDTO actualizarCliente (Long id, ClienteUpdateDTO clienteUpdate);
      List<ClienteResponseDTO> ListarClientes ();

    
}
