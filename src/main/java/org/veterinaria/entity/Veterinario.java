package org.veterinaria.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "veterinarios")
@Data
public class Veterinario extends PanacheEntity {

    @Column(nullable = false)
    private String nombres;

    private String especialidad;

    private String telefono;

    @OneToMany(mappedBy = "veterinario")
    private List<Cita> citas;

}