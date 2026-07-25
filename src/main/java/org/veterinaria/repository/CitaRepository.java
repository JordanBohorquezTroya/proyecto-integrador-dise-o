package org.veterinaria.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.veterinaria.entity.Cita;

@ApplicationScoped
public class CitaRepository implements PanacheRepository<Cita> {
}