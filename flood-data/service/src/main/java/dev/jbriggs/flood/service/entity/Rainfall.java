package dev.jbriggs.flood.service.entity;

import dev.jbriggs.flood.model.Station;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Rainfall entity.
 *
 * @author Jamie Briggs
 */
@Entity
@Table(name = "Rainfalls")
@IdClass(RainfallId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Rainfall {
  @Id
  @Column(name = "StationId")
  private long stationId;

  @ManyToOne
  @JoinColumn(name = "StationId", insertable = false, updatable = false)
  private StationName station;

  @Id
  @Column(name = "TimeStamp")
  private LocalDate timestamp;

  @Column(name = "Level")
  private BigDecimal level;
}

