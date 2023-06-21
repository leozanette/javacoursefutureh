package com.betrybe.controller;

import static io.restassured.RestAssured.given;
// import static org.junit.jupiter.api.Assertions.*;

import com.betrybe.dto.DroneDto;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

/**
 * author ubuntu.
 *
 */
@QuarkusTest
class DroneControllerTest {


  @Test
  void verificaSeRetornaStatus200() {
    given().when().get("/drone").then().statusCode(200);
  }

  @Test
  void verificaSalvar() {

    DroneDto corpo = new DroneDto();
    corpo.setModelo("ultima geracao");

    given().contentType("application/json").body(corpo).when().post("/drone").then()
        .statusCode(201);
  }

  @Test
  void verificaAtualizar() {

    DroneDto corpo = new DroneDto();
    corpo.setModelo("ultima geracao");

    given().contentType("application/json").body(corpo).when().post("/drone").then()
        .statusCode(201);

    corpo.setModelo("segunda geracao");

    given().contentType("application/json").body(corpo).when().put("/drone/1").then()
        .statusCode(200);

  }

  @Test
  void verificaDeletar() {

    DroneDto corpo = new DroneDto();
    corpo.setModelo("ultima geracao");

    given().contentType("application/json").body(corpo).when().post("/drone").then()
        .statusCode(201);

    given().contentType("application/json").when().delete("/drone/1").then().statusCode(204);

  }

}
