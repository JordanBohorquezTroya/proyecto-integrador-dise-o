package org.veterinaria.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;


public record CitaRequest(@NotNull(message = "La fecha es obligatoria")
                          LocalDate fecha,
                          @NotNull(message = "La hora es obligatoria")
                          LocalTime hora,
                          String motivo,
                          @NotNull(message = "La mascota es obligatoria")
                          Long mascotaId,
                          @NotNull(message = "El veterinario es obligatorio")
                          Long veterinarioId) {
}
