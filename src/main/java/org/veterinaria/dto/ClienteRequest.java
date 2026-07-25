package org.veterinaria.dto;


public record ClienteRequest(String cedula,
                             String nombres,
                             String apellidos,
                             String telefono,
                             String correo) {
}
