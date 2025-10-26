package dev.jbriggs.flood.service.controller;

import dev.jbriggs.flood.api.RainfallApi;
import dev.jbriggs.flood.model.RainfallStationGet200Response;
import dev.jbriggs.flood.model.Station;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

/**
 * Controller for handling requests related to rainfall data.
 *
 * @author Jamie Briggs
 */
@Controller
public class RainfallController implements RainfallApi {
  @Override
  public ResponseEntity<RainfallStationGet200Response> rainfallStationGet(Station station, String start, Integer page, Integer pagesize) {
    return null;
  }
}
