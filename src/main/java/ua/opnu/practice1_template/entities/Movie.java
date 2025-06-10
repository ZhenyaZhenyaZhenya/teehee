package ua.opnu.practice1_template.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")

public class Movie {
  @Id
  @SequenceGenerator(name = "movie_seq", sequenceName = "movie_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")

  private Long id;
  private String title;
  private Integer duration;
  private String genre;

  @OneToMany(mappedBy = "movie")
  @JsonIgnore
  private Set<Screening> screenings = new HashSet<>();
}
