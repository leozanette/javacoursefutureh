package com.betrybe.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
// import static org.junit.jupiter.api.Assertions.*;

import com.betrybe.dto.DroneDto;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

/**
 * author ubuntu.
 *
 */
@QuarkusTest
class EntregaControllerTest {

  @Test
  void verificaSeRetornaStatus200() {
    given().when().get("/entrega").then().statusCode(200);
  }

  @Test
  void verificaRetirar() {

    DroneDto corpo = new DroneDto();
    corpo.setModelo("ultima geracao");

    given().contentType("application/json").body(corpo).when().post("/drone").then()
        .statusCode(201);

    given().when().put("/entrega/retirar/1").then().statusCode(201);
  }

  @Test
  void verificaEntregar() {

    DroneDto corpo = new DroneDto();
    corpo.setModelo("ultima geracao");

    given().contentType("application/json").body(corpo).when().post("/drone").then()
        .statusCode(201);

    given().contentType("application/json").when().put("/entrega/retirar/1").then().statusCode(201);

    given().contentType("application/json").when().patch("/entrega/entregar/1").then()
        .statusCode(200);

  }

  @Test
  void verificaDeletar() {

    DroneDto corpo = new DroneDto();
    corpo.setModelo("ultima geracao");

    given().contentType("application/json").body(corpo).when().post("/drone").then()
        .statusCode(201);

    given().contentType("application/json").when().put("/entrega/retirar/1").then().statusCode(201);

    given().contentType("application/json").when().patch("/entrega/entregar/2").then()
        .statusCode(200);

    given().contentType("application/json").when().delete("/entrega/2").then().statusCode(204);

  }

}
