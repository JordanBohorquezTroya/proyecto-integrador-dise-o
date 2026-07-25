package org.veterinaria.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "mascotas")
@Data
public class Mascota extends PanacheEntity {

    @Column(nullable = false)
    private String nombre;

    private String especie;

    private String raza;

    private Integer edad;

    private Double peso;

    private String sexo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "mascota")
    private List<Cita> citas;

}