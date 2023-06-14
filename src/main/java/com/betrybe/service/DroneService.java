package com.betrybe.service;

import java.util.List;
import com.betrybe.dto.DroneDto;
import com.betrybe.model.Drone;
import com.betrybe.model.Entrega;
import com.betrybe.model.StatusEntrega;
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
    drone.setLatitude();
    drone.setLongitude();
    Drone.persist(drone);
  }

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

  @Transactional
  public void retirarEntrega(Long id) {
    Drone drone = Drone.findById(id);
    drone.setLatitude();
    drone.setLongitude();
    Drone.persist(drone);

    Entrega entrega = new Entrega();
    entrega.setStatus(StatusEntrega.PENDENTE);
    entrega.setDataRetirada();
    entrega.setDrone(drone);
    Entrega.persist(entrega);
  }

  @Transactional
  public void entregarEntrega(Long id) {
    Entrega entrega = Entrega.findById(id);
    Drone drone = entrega.getDrone();
    drone.setLatitude();
    drone.setLongitude();
    Drone.persist(drone);

    entrega.setStatus(StatusEntrega.OK);
    entrega.setDataEntrega();
    Entrega.persist(entrega);
  }

}
