package dev.jbriggs.flood.service.mapper;

import dev.jbriggs.flood.model.RainfallReading;
import dev.jbriggs.flood.model.Station;
import dev.jbriggs.flood.service.entity.Rainfall;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface RainfallMapper {

  @Mapping(target = "station.value", source = "stationId", qualifiedByName = "stationNameMapping")
  RainfallReading toResponse(Rainfall rainfall);

  @Named(value = "stationNameMapping")
  default Station fromString(String stationName){
    return Station.fromValue(stationName);
  }

}
