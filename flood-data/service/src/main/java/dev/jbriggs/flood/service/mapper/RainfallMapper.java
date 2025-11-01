package dev.jbriggs.flood.service.mapper;

import dev.jbriggs.flood.model.RainfallReading;
import dev.jbriggs.flood.model.RainfallStationGet200Response;
import dev.jbriggs.flood.model.Station;
import dev.jbriggs.flood.service.entity.Rainfall;
import dev.jbriggs.flood.service.entity.StationName;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface RainfallMapper {

  @Mapping(target = "level", source = "rainfall.level")
  @Mapping(target = "station", source = "stationName.name", qualifiedByName = "stationNameMapping")
  RainfallReading toReading(Rainfall rainfall, StationName stationName);

  @Named(value = "stationNameMapping")
  default Station fromString(String stationName){
    return Station.fromValue(stationName);
  }

  @Mapping(target = "readings", source = "rainfallPage.content")
  RainfallStationGet200Response toResponse(Page<Rainfall> rainfallPage, StationName stationName);

}
