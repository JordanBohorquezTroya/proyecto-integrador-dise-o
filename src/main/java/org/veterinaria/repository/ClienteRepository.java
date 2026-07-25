package org.veterinaria.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.veterinaria.entity.Cliente;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {
}