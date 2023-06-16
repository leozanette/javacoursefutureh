package com.betrybe.service;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.jboss.resteasy.reactive.multipart.FileUpload;
import com.betrybe.model.Entrega;
import com.betrybe.model.FormData;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EntregaService {

  public List<Entrega> listar() {
    return Entrega.listAll();
  }
}
