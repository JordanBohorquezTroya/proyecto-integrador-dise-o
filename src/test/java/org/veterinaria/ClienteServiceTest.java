package org.veterinaria;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.veterinaria.dto.ClienteRequest;
import org.veterinaria.entity.Cliente;
import org.veterinaria.service.ClienteService;

import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class ClienteServiceTest {

    @Inject
    ClienteService clienteService;

    @Test
    @Transactional
    void deberiaRegistrarCliente() {
        ClienteRequest request = new ClienteRequest(
                "0102030405",
                "Juan",
                "Perez",
                "0999999999",
                "juan@gmail.com"
        );

        Cliente cliente = clienteService.registrar(request);

        assertNotNull(cliente);
        assertNotNull(cliente.id);
        assertEquals("Juan", cliente.getNombres());
    }

}
