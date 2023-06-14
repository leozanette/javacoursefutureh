package com.betrybe.service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import com.betrybe.model.Entrega;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EntregaService {

  public List<Entrega> listar() {
    return Entrega.listAll();
  }

  public List<File> listarVideos() {
    List<Entrega> entregas = Entrega.listAll();
    List<File> videos =
        entregas.stream().map(entrega -> entrega.getVideo()).collect(Collectors.toList());
    return videos;
  }

}
