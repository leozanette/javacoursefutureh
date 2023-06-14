package com.betrybe.model;

import java.io.File;
import java.time.LocalDateTime;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Entrega extends PanacheEntity {
  private Long id;
  private LocalDateTime dataEntrega;
  private LocalDateTime dataRetirada;
  private StatusEntrega status;
  private File video;

  @ManyToOne
  private Drone drone;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getDataEntrega() {
    return dataEntrega;
  }

  public void setDataEntrega() {
    LocalDateTime dataEntrega = LocalDateTime.now();
    this.dataEntrega = dataEntrega;
  }

  public StatusEntrega getStatus() {
    return status;
  }

  public void setStatus(StatusEntrega status) {
    this.status = status;
  }

  public Drone getDrone() {
    return drone;
  }

  public void setDrone(Drone drone) {
    this.drone = drone;
  }

  public LocalDateTime getDataRetirada() {
    return dataRetirada;
  }

  public void setDataRetirada() {
    LocalDateTime dataRetirada = LocalDateTime.now();
    this.dataRetirada = dataRetirada;
  }

  public File getVideo() {
    return video;
  }

  public void setVideo(File video) {
    this.video = video;
  }


}
