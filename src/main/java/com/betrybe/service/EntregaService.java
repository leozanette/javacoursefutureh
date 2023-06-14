package com.betrybe.service;

import java.util.List;
import com.betrybe.model.Entrega;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EntregaService {

  public List<Entrega> listar() {
    return Entrega.listAll();
  }

}
