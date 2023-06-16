package com.betrybe.model;

import java.time.LocalDateTime;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Entrega extends PanacheEntity {
  private Long id;
  private LocalDateTime dataEntrega;
  private LocalDateTime dataRetirada;
  private StatusEntrega status;

  @OneToOne
  @JsonbTransient
  private Video video;

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

  public Video getVideo() {
    return video;
  }

  public void setVideo(Video video) {
    this.video = video;
  }


}
