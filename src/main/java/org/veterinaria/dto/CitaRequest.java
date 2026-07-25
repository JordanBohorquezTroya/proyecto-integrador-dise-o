package org.veterinaria.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record CitaRequest(LocalDate fecha,
                          LocalTime hora,
                          String motivo,
                          Long mascotaId,
                          Long veterinarioId) {
}