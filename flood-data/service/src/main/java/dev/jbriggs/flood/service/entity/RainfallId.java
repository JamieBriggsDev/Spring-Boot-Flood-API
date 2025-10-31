package dev.jbriggs.flood.service.entity;

import java.io.Serializable;
import java.time.LocalDate;

record RainfallId(long stationId, LocalDate timestamp) implements Serializable {
}
