package com.betrybe.controller;

import com.betrybe.model.Entrega;
import com.betrybe.service.EntregaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
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

  /**
   * metodo para listar todas as entegas.
   */
  @GET
  public List<Entrega> listar() {
    List<Entrega> entregas = entregaService.listar();

    return entregas;
  }

  @Path("/retirar/{id}")
  @PUT
  public void retirarEntrega(@PathParam("id") Long id) {
    entregaService.retirarEntrega(id);
  }

  @Path("/entregar/{id}")
  @PUT
  public void entregarEntrega(@PathParam("id") Long id) {
    entregaService.entregarEntrega(id);
  }

  @Path("{id}")
  @DELETE
  public void deletar(@PathParam("id") Long id) {
    entregaService.deletar(id);
  }
}
