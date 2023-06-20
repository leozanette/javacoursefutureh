package com.betrybe;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * gretting method quarkus.
 *
 */
@Path("/hello")
public class GreetingResource {

  /**
   * retorna uma saudacao.
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "Hello from RESTEasy Reactive";
  }
}
