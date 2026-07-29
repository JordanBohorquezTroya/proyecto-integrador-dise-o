package org.veterinaria.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteRequest(@NotBlank(message = "La cedula es obligatoria")
                             String cedula,
                             @NotBlank(message = "Los nombres son obligatorios")
                             String nombres,
                             @NotBlank(message = "Los apellidos son obligatorios")
                             String apellidos,
                             String telefono,
                             @Email(message = "El correo debe tener un formato valido")
                             String correo) {
}

