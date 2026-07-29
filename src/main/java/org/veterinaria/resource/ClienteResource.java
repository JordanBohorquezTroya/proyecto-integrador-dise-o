package org.veterinaria.resource;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.veterinaria.dto.ClienteRequest;
import org.veterinaria.entity.Cliente;
import org.veterinaria.service.ClienteService;

import java.util.List;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteService clienteService;

    @POST
    public Response registrar(@Valid ClienteRequest request) {
        return Response.status(Response.Status.CREATED)
                .entity(clienteService.registrar(request))
                .build();
    }

    @GET
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @GET
    @Path("/{id}")
    public Cliente obtener(@PathParam("id") Long id) {
        return clienteService.buscarPorId(id);
    }

}