package org.veterinaria.mapper;

import org.veterinaria.dto.MascotaRequest;
import org.veterinaria.entity.Cliente;
import org.veterinaria.entity.Mascota;

public final class MascotaMapper {

    private MascotaMapper() {
    }

    public static Mascota toEntity(MascotaRequest request, Cliente cliente) {
        Mascota mascota = new Mascota();
        mascota.setNombre(request.nombre());
        mascota.setEspecie(request.especie());
        mascota.setRaza(request.raza());
        mascota.setEdad(request.edad());
        mascota.setPeso(request.peso());
        mascota.setSexo(request.sexo());
        mascota.setCliente(cliente);
        return mascota;
    }
}
