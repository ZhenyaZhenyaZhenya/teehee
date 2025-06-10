package ua.opnu.practice1_template.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tickets")

public class Ticket {
  @Id
  @SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "screening_id", nullable = false)
  private Screening screening;

  private String seatNumber;
  private String customerName;

}
