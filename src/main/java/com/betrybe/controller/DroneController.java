package com.betrybe.controller;

import com.betrybe.dto.DroneDto;
import com.betrybe.model.Drone;
import com.betrybe.service.DroneService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * CRUD controller.
 *
 */
@Path("/drone")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DroneController {

  @Inject
  private DroneService droneService;

  /**
   * metodo para lsitar todos os drones.
   */
  @GET
  public Response listar() {
    List<Drone> drones = droneService.listar();

    return Response.ok(drones).status(200).build();
  }

  @POST
  public Response salvar(DroneDto droneDto) {
    droneService.salvar(droneDto);
    return Response.ok().status(201).build();
  }

  @Path("{id}")
  @PUT
  public Response atualizar(@PathParam("id") Long id, DroneDto droneDto) {
    droneService.atualizar(id, droneDto);
    return Response.ok().status(200).build();
  }

  @Path("{id}")
  @DELETE
  public Response deletar(@PathParam("id") Long id) {
    droneService.deletar(id);
    return Response.ok().status(204).build();
  }

}
