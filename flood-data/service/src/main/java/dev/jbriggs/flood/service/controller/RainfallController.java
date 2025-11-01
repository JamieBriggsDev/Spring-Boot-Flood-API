package dev.jbriggs.flood.service.controller;

import dev.jbriggs.flood.api.RainfallApi;
import dev.jbriggs.flood.model.RainfallReading;
import dev.jbriggs.flood.model.RainfallStationGet200Response;
import dev.jbriggs.flood.model.Station;
import dev.jbriggs.flood.service.entity.Rainfall;
import dev.jbriggs.flood.service.entity.RiverLevel;
import dev.jbriggs.flood.service.entity.StationName;
import dev.jbriggs.flood.service.mapper.RainfallMapper;
import dev.jbriggs.flood.service.repository.RainfallRepository;
import dev.jbriggs.flood.service.repository.RiverLevelRepository;
import dev.jbriggs.flood.service.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

/**
 * Controller for handling requests related to rainfall data.
 *
 * @author Jamie Briggs
 */
@Controller
@RequiredArgsConstructor
public class RainfallController implements RainfallApi {

  private final StationRepository stationRepository;
  private final RainfallRepository rainfallRepository;
  private final RiverLevelRepository riverLevelRepository;
  private final RainfallMapper rainfallMapper;

  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


  @Override
  public ResponseEntity<RainfallStationGet200Response> rainfallStationGet(Station station, String start, Integer page, Integer pagesize) {
    try {
      LocalDate startDate = LocalDate.parse(start, formatter);
      PageRequest pageable = PageRequest.of(page, pagesize);
      List<StationName> stationList = stationRepository.findAll();
      List<Rainfall> rainfallList = rainfallRepository.findAll();
      List<RiverLevel> riverList = riverLevelRepository.findAll();
      Optional<StationName> stationName = stationRepository.getByName(station.getValue());
      RainfallStationGet200Response result = stationName
          .map(x -> {
            Page<Rainfall> rainfall = rainfallRepository.findAllByStationIdAndTimestampAfter(x.getId(), startDate, pageable);
            return rainfallMapper.toResponse(rainfall, x);
          })
          .orElseThrow();
      return ResponseEntity.ok(result);
    } catch (DateTimeParseException dateTimeException) {
      return ResponseEntity.badRequest().build();
    }
  }
}
