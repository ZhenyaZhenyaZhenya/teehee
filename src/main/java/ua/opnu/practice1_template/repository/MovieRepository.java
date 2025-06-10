package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.opnu.practice1_template.entities.Movie;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
  List<Movie> findByGenre(String genre);

  @Query("SELECT m.duration FROM Movie m")
  List<Integer> findAllDurations();
}
