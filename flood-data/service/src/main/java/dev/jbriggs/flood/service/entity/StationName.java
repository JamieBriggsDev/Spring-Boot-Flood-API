package dev.jbriggs.flood.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Station name entity.
 *
 * @author Jamie Briggs
 */
@Entity
@Table(name = "StationNames")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class StationName {
  @Id
  @Column(name = "Id")
  private long id;

  @Column(name = "Name")
  private String name;
}
