package com.betrybe.service;

import java.util.List;
import com.betrybe.dto.DroneDto;
import com.betrybe.model.Drone;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DroneService {

  public List<Drone> listar() {
    return Drone.listAll();
  }

  @Transactional
  public void salvar(DroneDto droneDto) {
    Drone drone = new Drone();
    drone.setModelo(droneDto.getModelo());
    Drone.persist(drone);
  }
}
