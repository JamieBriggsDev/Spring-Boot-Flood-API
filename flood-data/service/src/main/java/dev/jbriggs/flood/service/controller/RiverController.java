package dev.jbriggs.flood.service.controller;

import dev.jbriggs.flood.api.RiverApi;
import dev.jbriggs.flood.model.RiverGet200Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

/**
 * Controller for handling requests related to river data.
 *
 * @author Jamie Briggs
 */
@Controller
public class RiverController implements RiverApi {
  @Override
  public ResponseEntity<RiverGet200Response> riverGet(String start, Integer page, Integer pagesize) {
    return null;
  }
}
