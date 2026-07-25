package org.veterinaria;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.veterinaria.dto.ClienteRequest;
import org.veterinaria.dto.MascotaRequest;
import org.veterinaria.entity.Cliente;
import org.veterinaria.entity.Mascota;
import org.veterinaria.repository.ClienteRepository;
import org.veterinaria.service.ClienteService;
import org.veterinaria.service.MascotaService;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class MascotaServiceTest {

    @Inject
    ClienteRepository clienteRepository;

    @Inject
    MascotaService mascotaService;

    @Test
    @Transactional
    void deberiaRegistrarMascota() {

        Cliente cliente = new Cliente();
        cliente.setCedula("0102030405");
        cliente.setNombres("Carlos");
        cliente.setApellidos("Perez");
        cliente.setTelefono("099999999");
        cliente.setCorreo("carlos@gmail.com");
        clienteRepository.persist(cliente);

        MascotaRequest request = new MascotaRequest(
                "Firulais",
                "Perro",
                "Labrador",
                4,
                20.5,
                "Macho",
                cliente.id
        );

        Mascota mascota = mascotaService.registrar(request);

        assertNotNull(mascota);
        assertEquals("Firulais", mascota.getNombre());

    }

}
