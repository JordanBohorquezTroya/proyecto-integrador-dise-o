package org.veterinaria.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.veterinaria.entity.Veterinario;

@ApplicationScoped
public class VeterinarioRepository implements PanacheRepository<Veterinario> {
}