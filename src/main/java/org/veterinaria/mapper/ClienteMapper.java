package org.veterinaria.mapper;

import org.veterinaria.dto.ClienteRequest;
import org.veterinaria.entity.Cliente;

public final class ClienteMapper {

    private ClienteMapper() {
    }

    public static Cliente toEntity(ClienteRequest request) {
        Cliente cliente = new Cliente();
        cliente.setCedula(request.cedula());
        cliente.setNombres(request.nombres());
        cliente.setApellidos(request.apellidos());
        cliente.setTelefono(request.telefono());
        cliente.setCorreo(request.correo());
        return cliente;
    }
}
