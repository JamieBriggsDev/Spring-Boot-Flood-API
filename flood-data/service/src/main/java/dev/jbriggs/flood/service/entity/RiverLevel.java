package dev.jbriggs.flood.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * River fall entity.
 *
 * @author Jamie Briggs
 */
@Entity
@Table(name = "RiverLevels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RiverLevel {

  @Id
  @Column(name = "TimeStamp")
  private LocalDate timestamp;

  @Column(name = "Level")
  private BigDecimal level;
}
