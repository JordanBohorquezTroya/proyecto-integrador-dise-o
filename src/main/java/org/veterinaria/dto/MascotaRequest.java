package org.veterinaria.dto;

public record MascotaRequest(String nombre,
                             String especie,
                             String raza,
                             Integer edad,
                             Double peso,
                             String sexo,
                             Long clienteId) {
}