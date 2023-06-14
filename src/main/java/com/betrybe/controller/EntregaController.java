package com.betrybe.controller;

import java.util.List;
import com.betrybe.model.Entrega;
import com.betrybe.service.EntregaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/entrega")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EntregaController {
  @Inject
  private EntregaService entregaService;

  @GET
  public List<Entrega> listar() {
    List<Entrega> entregas = entregaService.listar();

    return entregas;
  }
}
