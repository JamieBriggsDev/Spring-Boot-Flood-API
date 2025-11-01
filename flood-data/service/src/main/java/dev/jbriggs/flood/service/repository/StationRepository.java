package dev.jbriggs.flood.service.repository;

import dev.jbriggs.flood.service.entity.StationName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StationRepository extends JpaRepository<StationName, Long> {
  Optional<StationName> getByName(String name);
}
