package dev.jbriggs.flood.service.repository;

import dev.jbriggs.flood.service.entity.Rainfall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RainfallRepository extends JpaRepository<Rainfall, Long> {

  Page<Rainfall> findAllByStationIdAndTimestampAfter(Long stationId, LocalDate timestampAfter, Pageable pageable);
}
