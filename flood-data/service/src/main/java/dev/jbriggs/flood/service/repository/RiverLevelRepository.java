package dev.jbriggs.flood.service.repository;

import dev.jbriggs.flood.service.entity.RiverLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RiverLevelRepository extends JpaRepository<RiverLevel, LocalDate> {

  List<RiverLevel> findAll();
  Page<RiverLevel> findRiverLevelsByTimestampAfter(LocalDate timestampAfter, Pageable pageable);
}
