package org.veterinaria.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.veterinaria.dto.CitaRequest;
import org.veterinaria.entity.Cita;
import org.veterinaria.entity.Mascota;
import org.veterinaria.entity.Veterinario;
import org.veterinaria.mapper.CitaMapper;
import org.veterinaria.repository.CitaRepository;
import org.veterinaria.repository.MascotaRepository;
import org.veterinaria.repository.VeterinarioRepository;

import java.util.List;
import static org.veterinaria.util.BusquedaUtil.obtenerOFallar;

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

        Mascota mascota = obtenerOFallar(mascotaRepository, request.mascotaId(), "Mascota no encontrada");

        Veterinario veterinario = obtenerOFallar(veterinarioRepository, request.veterinarioId(), "Veterinario no encontrado");

        Cita cita = CitaMapper.toEntity(request, mascota, veterinario);

        citaRepository.persist(cita);
        return cita;
    }

    public List<Cita> listar(){
        return citaRepository.listAll();
    }

    public Cita buscarPorId(Long id){
        return obtenerOFallar(citaRepository, id, "Cita no encontrada");
    }

}