package org.veterinaria.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.veterinaria.dto.CitaRequest;
import org.veterinaria.entity.Cita;
import org.veterinaria.entity.Mascota;
import org.veterinaria.entity.Veterinario;
import org.veterinaria.repository.CitaRepository;
import org.veterinaria.repository.MascotaRepository;
import org.veterinaria.repository.VeterinarioRepository;

import java.util.List;

@ApplicationScoped
public class CitaService {

    @Inject
    CitaRepository citaRepository;

    @Inject
    MascotaRepository mascotaRepository;

    @Inject
    VeterinarioRepository veterinarioRepository;

    @Transactional
    public Cita registrar(CitaRequest request){

        Mascota mascota = mascotaRepository.findById(request.mascotaId());

        if(mascota == null){
            throw new NotFoundException("Mascota no encontrada");
        }

        Veterinario veterinario = veterinarioRepository.findById(request.veterinarioId());

        if(veterinario == null){
            throw new NotFoundException("Veterinario no encontrado");
        }

        Cita cita = new Cita();

        cita.setFecha(request.fecha());
        cita.setHora(request.hora());
        cita.setMotivo(request.motivo());
        cita.setEstado("PROGRAMADA");
        cita.setMascota(mascota);
        cita.setVeterinario(veterinario);
        citaRepository.persist(cita);
        return cita;
    }

    public List<Cita> listar(){
        return citaRepository.listAll();
    }

    public Cita buscarPorId(Long id){
        Cita cita = citaRepository.findById(id);
        if(cita == null){
            throw new NotFoundException("Cita no encontrada");
        }
        return cita;
    }

}