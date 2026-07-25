package org.veterinaria;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.veterinaria.dto.CitaRequest;
import org.veterinaria.dto.ClienteRequest;
import org.veterinaria.entity.Cita;
import org.veterinaria.entity.Cliente;
import org.veterinaria.entity.Mascota;
import org.veterinaria.entity.Veterinario;
import org.veterinaria.repository.MascotaRepository;
import org.veterinaria.repository.VeterinarioRepository;
import org.veterinaria.service.CitaService;
import org.veterinaria.service.ClienteService;

import jakarta.inject.Inject;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class CitaServiceTest {

    @Inject
    MascotaRepository mascotaRepository;

    @Inject
    VeterinarioRepository veterinarioRepository;

    @Inject
    CitaService citaService;

    @Test
    @Transactional
    void deberiaRegistrarCita() {

        Mascota mascota = new Mascota();
        mascota.setNombre("Firulais");
        mascotaRepository.persist(mascota);

        Veterinario veterinario = new Veterinario();
        veterinario.setNombres("Luis");
        veterinarioRepository.persist(veterinario);

        CitaRequest request = new CitaRequest(
                LocalDate.now(),
                LocalTime.of(10,30),
                "Vacunación",
                mascota.id,
                veterinario.id
        );

        Cita cita = citaService.registrar(request);

        assertNotNull(cita);
        assertEquals("PROGRAMADA", cita.getEstado());

    }

}