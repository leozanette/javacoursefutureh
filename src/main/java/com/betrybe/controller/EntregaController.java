package com.betrybe.controller;

import java.io.File;
import java.util.List;
import org.jboss.resteasy.reactive.MultipartForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;
import com.betrybe.model.Entrega;
import com.betrybe.service.EntregaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
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

  @Path("/video")
  @GET
  public List<File> listarVideos() {
    List<File> videos = entregaService.listarVideos();

    return videos;
  }

  @Path("/video/{id}")
  @PATCH
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public String publicarVideo(@PathParam("id") Long id, @MultipartForm FileUpload file) {
    entregaService.iserirVideo(id, file);
    System.out.println(file.toString());
    return file.toString();
  }
}
