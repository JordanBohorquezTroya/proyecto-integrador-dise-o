package org.veterinaria.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.veterinaria.dto.ClienteRequest;
import org.veterinaria.entity.Cliente;
import org.veterinaria.mapper.ClienteMapper;
import org.veterinaria.repository.ClienteRepository;

import java.util.List;

import static org.veterinaria.util.BusquedaUtil.obtenerOFallar;

@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    @Transactional
    public Cliente registrar(ClienteRequest request){
        Cliente cliente = ClienteMapper.toEntity(request);
        clienteRepository.persist(cliente);
        return cliente;
    }


    public List<Cliente> listar(){
        return clienteRepository.listAll();
    }

    public Cliente buscarPorId(Long id){
        return obtenerOFallar(clienteRepository, id, "Cliente no encontrado");
    }

}