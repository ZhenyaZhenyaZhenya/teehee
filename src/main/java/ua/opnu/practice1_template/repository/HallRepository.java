package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.practice1_template.entities.Hall;

public interface HallRepository extends JpaRepository<Hall, Long> {
}
