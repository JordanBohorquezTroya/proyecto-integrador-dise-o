package org.veterinaria.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dto.CitaRequest;
import org.veterinaria.entity.Cita;
import org.veterinaria.service.CitaService;

import java.util.List;

@Path("/citas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CitaResource {

    @Inject
    CitaService citaService;

    @POST
    public Response registrar(@Valid CitaRequest request) {
        return Response.status(Response.Status.CREATED)
                .entity(citaService.registrar(request))
                .build();
    }

    @GET
    public List<Cita> listar() {
        return citaService.listar();
    }

    @GET
    @Path("/{id}")
    public Cita obtener(@PathParam("id") Long id) {
        return citaService.buscarPorId(id);
    }

}