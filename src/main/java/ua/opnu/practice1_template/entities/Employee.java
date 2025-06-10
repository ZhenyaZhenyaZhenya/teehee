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
@Table(name = "employees")

public class Employee {
  @Id
  @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
  private Long id;
  private String name;
  private String role;
}
