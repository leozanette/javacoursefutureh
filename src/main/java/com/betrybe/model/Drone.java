package com.betrybe.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.util.Random;

/**
 * drone entity.
 *
 */
@Entity
public class Drone extends PanacheEntity {

  private Long id;
  private String modelo;
  private double latitude;
  private double longitude;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public double getLatitude() {
    return latitude;
  }

  /**
   * metodo para setar latitude de modo randomico.
   */
  public void setLatitude() {
    Random random = new Random();
    int randomNumber = random.nextInt(18000001) - 9000000;

    double result = (double) randomNumber / 100000;

    this.latitude = result;
  }

  public double getLongitude() {
    return longitude;
  }

  /**
   * metodo para setar longitude de modo randomico.
   */
  public void setLongitude() {
    Random random = new Random();
    int randomNumber = random.nextInt(36000001) - 18000000;

    double result = (double) randomNumber / 100000;

    this.longitude = result;
  }
}
