package dev.jbriggs.flood.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entrypoint of the application.
 *
 * @author Jamie Briggs
 */
@SpringBootApplication
public class FloodApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(FloodApiApplication.class, args);
  }

}
