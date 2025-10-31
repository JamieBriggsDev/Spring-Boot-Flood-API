package dev.jbriggs.flood.service.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.yaml")
public class RiverLevelRepositoryTest {

  @Autowired
  RiverLevelRepository riverLevelRepository;

  @Test
  @DisplayName("Should load river levels - unpaged")
  void shouldLoadRiverLevels() {
    // Given
    LocalDate timestampAfter = LocalDate.of(2023, 1, 1);
    // When
    var all = riverLevelRepository.findAll();
    var result = riverLevelRepository.findRiverLevelsByTimestampAfter(timestampAfter, Pageable.unpaged());
    // Then
    assertThat(all.size()).isGreaterThan(0);
    assertThat(result.getTotalElements()).isGreaterThan(0);
  }
}
