package com.betrybe.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import com.betrybe.model.Entrega;
import com.betrybe.model.FormData;
import com.betrybe.model.Video;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class VideoService {



  @ConfigProperty(name = "quarkus.http.body.uploads-directory")
  String directory;

  public List<Video> listarVideos() {
    List<Video> videos = Video.listAll();
    return videos;
  }

  @Transactional
  public Video sendUpload(Long id, FormData data) throws IOException {
    Video video = new Video();
    Entrega entrega = Entrega.findById(id);

    String fileName = UUID.randomUUID() + "-" + data.getFile().fileName();

    video.setOriginalName(data.getFile().fileName());
    video.setKeyName(fileName);
    video.setMimetype(data.getFile().contentType());
    video.setFilesize(data.getFile().size());
    video.setCreatedAt(new Date());
    video.setEntrega(entrega);
    entrega.setVideo(video);

    Video.persist(video);
    // Entrega.persist(entrega);

    Files.copy(data.getFile().filePath(), Paths.get(directory + fileName));
    return video;
  }
}
