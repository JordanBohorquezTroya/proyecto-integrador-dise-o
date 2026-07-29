package org.veterinaria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MascotaRequest(@NotBlank(message = "El nombre es obligatorio")
                             String nombre,
                             String especie,
                             String raza,
                             @Positive(message = "La edad debe ser positiva")
                             Integer edad,
                             @Positive(message = "El peso debe ser positivo")
                             Double peso,
                             String sexo,
                             @NotNull(message = "El cliente es obligatorio")
                             Long clienteId) {
}