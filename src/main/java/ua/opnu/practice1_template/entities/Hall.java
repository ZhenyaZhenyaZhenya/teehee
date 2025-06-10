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
@Table(name = "halls")

public class Hall {
  @Id
  @SequenceGenerator(name = "hall_seq", sequenceName = "hall_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hall_seq")
  private Long id;
  private String name;
  private Integer seats;

  @OneToMany(mappedBy = "hall")
  @JsonIgnore
  private Set<Screening> screenings = new HashSet<>();
}
