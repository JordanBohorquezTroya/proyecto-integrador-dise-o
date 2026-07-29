package org.veterinaria.mapper;

import org.veterinaria.dto.CitaRequest;
import org.veterinaria.entity.Cita;
import org.veterinaria.entity.EstadoCita;
import org.veterinaria.entity.Mascota;
import org.veterinaria.entity.Veterinario;

public final class CitaMapper {

    private CitaMapper() {
    }

    public static Cita toEntity(CitaRequest request, Mascota mascota, Veterinario veterinario) {
        Cita cita = new Cita();
        cita.setFecha(request.fecha());
        cita.setHora(request.hora());
        cita.setMotivo(request.motivo());
        cita.setMascota(mascota);
        cita.setVeterinario(veterinario);
        cita.setEstado(EstadoCita.PROGRAMADA);
        return cita;
    }
}
