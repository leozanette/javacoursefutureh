package com.betrybe.controller;

import static io.restassured.RestAssured.given;
// import static org.junit.jupiter.api.Assertions.*;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

/**
 * author ubuntu.
 *
 */
@QuarkusTest
class VideoControllerTest {

  @Test
  void verificaListarVideo() {
    given().when().get("/video").then().statusCode(200);
  }

}
