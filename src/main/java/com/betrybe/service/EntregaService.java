package com.betrybe.service;

import com.betrybe.model.Drone;
import com.betrybe.model.Entrega;
import com.betrybe.model.StatusEntrega;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 * service da classe entrega.
 *
 */
@ApplicationScoped
public class EntregaService {

  public List<Entrega> listar() {
    return Entrega.listAll();
  }


  /**
   * aram localiza drone por id.
   */
  @Transactional
  public void retirarEntrega(Long id) {
    // Drone drone = Drone.findById(id);
    // drone.setLatitude();
    // drone.setLongitude();
    // Drone.persist(drone);

    Entrega entrega = new Entrega();
    entrega.setStatus(StatusEntrega.PENDENTE);
    entrega.setDataRetirada();
    entrega.setDrone(Drone.findById(id));
    Entrega.persist(entrega);
  }

  /**
   * param localiza entrega por id.
   */
  @Transactional
  public void entregarEntrega(Long id) {
    Entrega entrega = Entrega.findById(id);
    // Drone drone = entrega.getDrone();
    // drone.setLatitude();
    // drone.setLongitude();
    // Drone.persist(drone);

    entrega.setStatus(StatusEntrega.OK);
    entrega.setDataEntrega();
    Entrega.persist(entrega);
  }

  @Transactional
  public void deletar(Long id) {
    Entrega.deleteById(id);
  }
}
