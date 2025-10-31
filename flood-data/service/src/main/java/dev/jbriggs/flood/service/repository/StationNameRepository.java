package dev.jbriggs.flood.service.repository;

import dev.jbriggs.flood.service.entity.StationName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationNameRepository extends CrudRepository<StationName, Long> {
}
