package org.veterinaria.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "clientes")
@Data
public class Cliente extends PanacheEntity {

    @Column(nullable = false)
    private String cedula;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    private String telefono;

    private String correo;

    @OneToMany(mappedBy = "cliente")
    private List<Mascota> mascotas;

}