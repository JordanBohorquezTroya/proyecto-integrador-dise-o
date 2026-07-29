package org.veterinaria.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dto.MascotaRequest;
import org.veterinaria.entity.Mascota;
import org.veterinaria.service.MascotaService;

import java.util.List;

@Path("/mascotas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MascotaResource {

    @Inject
    MascotaService mascotaService;

    @POST
    public Response registrar(@Valid MascotaRequest request) {
        return Response.status(Response.Status.CREATED)
                .entity(mascotaService.registrar(request))
                .build();
    }

    @GET
    public List<Mascota> listar() {
        return mascotaService.listar();
    }

    @GET
    @Path("/{id}")
    public Mascota obtener(@PathParam("id") Long id) {
        return mascotaService.buscarPorId(id);
    }

}