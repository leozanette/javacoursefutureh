package com.betrybe.controller;

import com.betrybe.model.Entrega;
import com.betrybe.service.DroneService;
import com.betrybe.service.EntregaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * controller da entidade entrega.
 *
 */
@Path("/entrega")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EntregaController {
  @Inject
  private EntregaService entregaService;

  @Inject
  private DroneService droneService;

  /**
   * metodo para listar todas as entegas.
   */
  @GET
  public Response listar() {
    List<Entrega> entregas = entregaService.listar();

    return Response.ok(entregas).status(200).build();
  }

  @Path("/retirar/{id}")
  @PUT
  public Response retirarEntrega(@PathParam("id") Long id) {
    entregaService.retirarEntrega(id);
    return Response.ok().status(201).build();
  }

  @Path("/entregar/{id}")
  @PATCH
  public Response entregarEntrega(@PathParam("id") Long id) {
    entregaService.entregarEntrega(id);
    return Response.ok().status(200).build();
  }

  @Path("{id}")
  @DELETE
  public Response deletar(@PathParam("id") Long id) {
    entregaService.deletar(id);
    return Response.ok().status(204).build();
  }
}
