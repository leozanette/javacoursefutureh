package com.betrybe.service;

import com.betrybe.dto.DroneDto;
import com.betrybe.model.Drone;
import com.betrybe.model.Entrega;
import com.betrybe.model.StatusEntrega;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 * Service da entity Drone.
 *
 */
@ApplicationScoped
public class DroneService {

  public List<Drone> listar() {
    return Drone.listAll();
  }

  /**
   * save drone no db utilizando o data transfer object droneDto.
   */
  @Transactional
  public void salvar(DroneDto droneDto) {
    Drone drone = new Drone();
    drone.setModelo(droneDto.getModelo());
    drone.setLatitude();
    drone.setLongitude();
    Drone.persist(drone);
  }

  /**
   * Método para atualizar um drone. param id ID utilizado para localizar o drone param droneDto
   * Objeto contendo o modelo do drone.
   */
  @Transactional
  public void atualizar(Long id, DroneDto droneDto) {
    Drone drone = Drone.findById(id);
    drone.setModelo(droneDto.getModelo());
    drone.setLatitude();
    drone.setLongitude();
    Drone.persist(drone);
  }

  @Transactional
  public void deletar(Long id) {
    Drone.deleteById(id);
  }

}
