package org.veterinaria.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.veterinaria.dto.MascotaRequest;
import org.veterinaria.entity.Cliente;
import org.veterinaria.entity.Mascota;
import org.veterinaria.repository.ClienteRepository;
import org.veterinaria.repository.MascotaRepository;

import java.util.List;

@ApplicationScoped
public class MascotaService {

    @Inject
    MascotaRepository mascotaRepository;

    @Inject
    ClienteRepository clienteRepository;

    @Transactional
    public Mascota registrar(MascotaRequest request){

        Cliente cliente = clienteRepository.findById(request.clienteId());

        if(cliente == null){
            throw new NotFoundException("Cliente no encontrado");
        }

        Mascota mascota = new Mascota();

        mascota.setNombre(request.nombre());
        mascota.setEspecie(request.especie());
        mascota.setRaza(request.raza());
        mascota.setEdad(request.edad());
        mascota.setPeso(request.peso());
        mascota.setSexo(request.sexo());

        mascota.setCliente(cliente);

        mascotaRepository.persist(mascota);

        return mascota;
    }

    public List<Mascota> listar(){
        return mascotaRepository.listAll();
    }

    public Mascota buscarPorId(Long id){

        Mascota mascota = mascotaRepository.findById(id);

        if(mascota == null){
            throw new NotFoundException("Mascota no encontrada");
        }

        return mascota;
    }

}