package com.betrybe.controller;

import java.io.IOException;
import java.util.List;
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

@Path("/video")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.MULTIPART_FORM_DATA)
public class VideoController {

  @Inject
  private VideoService videoService;

  @GET
  public List<Video> listarVideos() {
    List<Video> videos = videoService.listarVideos();

    return videos;
  }

  @Path("/{id}")
  @POST
  public Response publicarVideo(@PathParam("id") Long id, FormData file) throws IOException {
    Video video = videoService.sendUpload(id, file);
    return Response.ok(video).status(201).build();
  }
}
