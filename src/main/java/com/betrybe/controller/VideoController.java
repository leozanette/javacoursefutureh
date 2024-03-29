package com.betrybe.controller;

import com.betrybe.model.FormData;
import com.betrybe.model.Video;
import com.betrybe.service.VideoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * controller da entidade video.
 *
 */
@Path("/video")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.MULTIPART_FORM_DATA)
public class VideoController {

  @Inject
  private VideoService videoService;

  /**
   * metodo listar todos os videos.
   */
  @GET
  public Response listarVideos() {
    List<Video> videos = videoService.listarVideos();

    return Response.ok(videos).status(200).build();
  }

  @Path("/{id}")
  @POST
  public Response publicarVideo(@PathParam("id") Long id, FormData file) throws IOException {
    Video video = videoService.sendUpload(id, file);
    return Response.ok(video).status(201).build();
  }

  /**
   * param id procura video pelo id return video para download.
   */
  @Path("/{id}")
  @GET
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public Response downloadVideo(@PathParam("id") Long id) {
    File download = videoService.download(id);

    String contentDisposition = "attachment; filename=\"" + download.getName() + "\"";
    return Response.ok(download).header("Content-Disposition", contentDisposition).build();
  }
}
