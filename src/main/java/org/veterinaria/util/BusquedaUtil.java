package org.veterinaria.util;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.ws.rs.NotFoundException;


public final class BusquedaUtil {

    private BusquedaUtil() {
    }

    public static <T, ID> T obtenerOFallar(PanacheRepositoryBase<T, ID> repository, ID id, String mensaje) {
        T entidad = repository.findById(id);
        if (entidad == null) {
            throw new NotFoundException(mensaje);
        }
        return entidad;
    }
}
