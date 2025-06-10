package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.practice1_template.entities.Screening;
import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
  List<Screening> findByMovie_Id(Long movieId);
}
