package com.betrybe.service;

import com.betrybe.model.Entrega;
import com.betrybe.model.FormData;
import com.betrybe.model.Video;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * service da classe video.
 *
 */
@ApplicationScoped
public class VideoService {

  @ConfigProperty(name = "quarkus.http.body.uploads-directory")
  String directory;

  public List<Video> listarVideos() {
    List<Video> videos = Video.listAll();
    return videos;
  }

  /**
   * metodo para upload de arquivo.
   */
  @Transactional
  public Video sendUpload(Long id, FormData data) throws IOException {
    Video video = new Video();
    // Entrega entrega = Entrega.findById(id);

    String fileName = UUID.randomUUID() + "-" + data.getFile().fileName();

    video.setOriginalName(data.getFile().fileName());
    video.setKeyName(fileName);
    video.setMimetype(data.getFile().contentType());
    video.setFilesize(data.getFile().size());
    video.setCreatedAt(new Date());
    video.setEntrega(Entrega.findById(id));
    // entrega.setVideo(video);

    Video.persist(video);

    Files.copy(data.getFile().filePath(), Paths.get(directory + fileName));
    return video;
  }

  /**
   * param id para encontrar o video.
   * 
   */
  public File download(Long id) {
    Video video = Video.findById(id);
    String filePath = Paths.get(directory, video.getKeyName()).toString();
    return new File(filePath);
  }
}
