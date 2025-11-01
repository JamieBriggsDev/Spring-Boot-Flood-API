package dev.jbriggs.flood.service.converter;

import dev.jbriggs.flood.model.Station;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToStationConverter implements Converter<String, Station> {

  @Override
  public Station convert(String source) {
    return Station.fromValue(source);
  }
}
