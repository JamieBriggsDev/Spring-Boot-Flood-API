package dev.jbriggs.flood.service.mapper;

import dev.jbriggs.flood.service.entity.Rainfall;
import dev.jbriggs.flood.service.entity.StationName;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

import static dev.jbriggs.flood.model.Station.ACOMB_CODLAW_HILL;

@DisplayName("Rainfall mapper test")
class RainfallMapperTest {


  RainfallMapper mapper;

  @BeforeEach
  void beforeEach() {
    mapper = new RainfallMapperImpl();
  }

  @Test
  @DisplayName("Should map all properties")
  void shouldMapAllProperties() {
    // Given
    Rainfall rainfall = Rainfall.builder()
        .level(BigDecimal.valueOf(123.45f))
        .stationId(123L)
        .timestamp(LocalDate.of(2023, 2, 3))
        .build();
    StationName stationName = StationName.builder().id(123L).name("acomb-codlaw-hill").build();
    // When
    var result = mapper.toReading(rainfall, stationName);
    // Then
    SoftAssertions.assertSoftly(softly -> {
      softly.assertThat(result.getLevel().equals(rainfall.getLevel())).isTrue();
      softly.assertThat(result.getStation()).isEqualTo(ACOMB_CODLAW_HILL);
      softly.assertThat(result.getTimestamp().equals(rainfall.getTimestamp().toString())).isTrue();
    });
  }

  @Test
  @DisplayName("Should map response")
  void shouldMapResponse() {
    // Given
    Rainfall rainfall = Rainfall.builder()
        .level(BigDecimal.valueOf(123.45f))
        .stationId(123L)
        .timestamp(LocalDate.of(2023, 2, 3))
        .build();
    StationName stationName = StationName.builder().id(123L).name("acomb-codlaw-hill").build();

    Page<Rainfall> input = new PageImpl<>(java.util.List.of(rainfall));
    // When
    var result = mapper.toResponse(input, stationName);
    // Then
    SoftAssertions.assertSoftly(softly -> {
      softly.assertThat(result.getReadings().size()).isEqualTo(1);
      softly.assertThat(result.getReadings().getFirst().getLevel().equals(rainfall.getLevel())).isTrue();
      softly.assertThat(result.getReadings().getFirst().getStation()).isEqualTo(ACOMB_CODLAW_HILL);
      softly.assertThat(result.getReadings().getFirst().getTimestamp().equals(rainfall.getTimestamp().toString())).isTrue();
    });
  }
}