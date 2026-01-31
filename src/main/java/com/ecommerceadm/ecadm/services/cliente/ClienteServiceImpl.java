package com.ecommerceadm.ecadm.services.cliente;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerceadm.ecadm.dto.ClienteDTOs.ClienteCreateDTO;
import com.ecommerceadm.ecadm.dto.ClienteDTOs.ClienteResponseDTO;
import com.ecommerceadm.ecadm.dto.ClienteDTOs.ClienteUpdateDTO;
import com.ecommerceadm.ecadm.models.Cliente;
import com.ecommerceadm.ecadm.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;

    private ClienteResponseDTO clienteToDTO (Cliente cliente){
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setEmail(cliente.getEmail());
        dto.setNombre(cliente.getNombre());
        dto.setDni(cliente.getDni());
        return dto;
    }
    @Override
    public ClienteResponseDTO obtenerClientePorID(Long id){
        Cliente cliente = clienteRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Cliente no encontrado"));
        return clienteToDTO(cliente);
    }
    @Override
    public ClienteResponseDTO obtenerClientePorDNI (String dni){
        Cliente cliente = clienteRepository.findByDni(dni)
        .orElseThrow(()-> new RuntimeException("Cliente no encontrado"));
        return clienteToDTO(cliente);
    }
    @Override
    public ClienteResponseDTO obtenerClientePorEmail (String email){
        Cliente cliente = clienteRepository.findByEmail(email)
        .orElseThrow(()-> new RuntimeException("Cliente no encontrado"));
        return clienteToDTO(cliente);
    }
    @Override
    public ClienteResponseDTO crearCliente (ClienteCreateDTO cliente){
        Cliente dto = new Cliente();
        dto.setNombre(cliente.getNombre());
        dto.setDni(cliente.getDni());
        dto.setEmail(cliente.getEmail());
        Cliente nuevoCliente = clienteRepository.save(dto);
        return clienteToDTO(nuevoCliente);
    }
    @Override
    public void eliminarCliente (Long id){
        Cliente c = clienteRepository.findById(id)
        .orElseThrow(()-> new RuntimeException ("Cliente no encontrado"));
        clienteRepository.deleteById(id);
    }
    @Override
    public ClienteResponseDTO actualizarCliente (Long id, ClienteUpdateDTO clienteUpdate){
        Cliente cliente = clienteRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Cliente no encontrado"));
        if (clienteUpdate.getNombre() != null){
            cliente.setNombre(clienteUpdate.getNombre());
        }
        if (clienteUpdate.getDni() != null){
            cliente.setDni(clienteUpdate.getDni());
        }
        if (clienteUpdate.getEmail() != null){
            cliente.setEmail(clienteUpdate.getEmail());
        }
        Cliente clienteActualizado = clienteRepository.save(cliente);
        return clienteToDTO(clienteActualizado);    
    }
    @Override
    public List<ClienteResponseDTO> ListarClientes (){
        return clienteRepository.findAll()
        .stream().map(this::clienteToDTO).toList();
    }
    
}
