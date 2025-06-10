package ua.opnu.practice1_template.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "screenings")

public class Screening {
  @Id
  @SequenceGenerator(name = "screening_seq", sequenceName = "screening_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "screening_seq")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "movie_id", nullable = false)
  private Movie movie;

  @ManyToOne
  @JoinColumn(name = "hall_id", nullable = false)
  private Hall hall;

  @OneToMany(mappedBy = "screening")
  @JsonIgnore
  private Set<Ticket> tickets = new HashSet<>();

  private LocalDateTime startTime;
}
