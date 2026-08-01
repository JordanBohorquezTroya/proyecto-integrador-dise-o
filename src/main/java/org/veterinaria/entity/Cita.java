package org.veterinaria.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "citas")
@Data
public class Cita extends PanacheEntity {

    private LocalDate fecha;

    private LocalTime hora;

    private String motivo;

    @Enumerated(EnumType.STRING)
    private EstadoCita estado;

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;


    public void confirmar() {
        validarTransicion();
        this.estado = EstadoCita.CONFIRMADA;
    }

    public void marcarComoAtendida() {
        validarTransicion();
        this.estado = EstadoCita.ATENDIDA;
    }

    public void cancelar() {
        validarTransicion();
        this.estado = EstadoCita.CANCELADA;
    }

    private void validarTransicion() {
        //validaciones
        if (estado == EstadoCita.ATENDIDA || estado == EstadoCita.CANCELADA) {
            throw new IllegalStateException(
                    "No se puede cambiar el estado de una cita que ya está " + estado);
        }
    }

}