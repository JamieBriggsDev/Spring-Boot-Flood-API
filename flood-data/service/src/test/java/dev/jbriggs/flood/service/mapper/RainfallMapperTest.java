package dev.jbriggs.flood.service.mapper;

import dev.jbriggs.flood.service.entity.Rainfall;
import dev.jbriggs.flood.service.entity.StationName;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

@DisplayName("Rainfall mapper test")
class RainfallMapperTest {


  RainfallMapper mapper;

  @BeforeEach
  void beforeEach(){
    mapper = new RainfallMapperImpl();
  }

  @Test
  @DisplayName("Should map all properties")
  void shouldMapAllProperties(){
    // Given
    Rainfall rainfall = Rainfall.builder()
        .level(BigDecimal.valueOf(123.45f))
        .stationId(123L)
        .station(StationName.builder()
            .id(123L)
            .name("acomb-codlaw-hill").build())
        .timestamp(LocalDate.of(2023, 2, 3))
        .build();
    // When
    var result = mapper.toResponse(rainfall);
    // Then
    SoftAssertions.assertSoftly(softly -> {
      softly.assertThat(result.getLevel().equals(rainfall.getLevel())).isTrue();
      softly.assertThat(result.getStation().getValue()).isEqualTo(rainfall.getStationId());
      softly.assertThat(result.getTimestamp().equals(rainfall.getTimestamp().toString())).isTrue();
    });
  }
}