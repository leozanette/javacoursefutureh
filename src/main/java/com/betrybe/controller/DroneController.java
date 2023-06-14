package com.betrybe.controller;

import java.util.List;
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

@Path("/drone")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DroneController {

  @Inject
  private DroneService droneService;

  @GET
  public List<Drone> listar() {
    List<Drone> drones = droneService.listar();

    return drones;
  }

  @POST
  public void salvar(DroneDto droneDto) {
    droneService.salvar(droneDto);
  }

  @Path("{id}")
  @PUT
  public void atualizar(@PathParam("id") Long id, DroneDto droneDto) {
    droneService.atualizar(id, droneDto);
  }

  @Path("{id}")
  @DELETE
  public void atualizar(@PathParam("id") Long id) {
    droneService.deletar(id);
  }

  @Path("/retirar/{id}")
  @PUT
  public void retirarEntrega(@PathParam("id") Long id) {
    droneService.retirarEntrega(id);
  }

  @Path("/entregar/{id}")
  @PUT
  public void entregarEntrega(@PathParam("id") Long id) {
    droneService.entregarEntrega(id);
  }
}
