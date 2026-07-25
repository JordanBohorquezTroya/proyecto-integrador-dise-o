package org.veterinaria.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.veterinaria.entity.Mascota;

@ApplicationScoped
public class MascotaRepository implements PanacheRepository<Mascota> {
}