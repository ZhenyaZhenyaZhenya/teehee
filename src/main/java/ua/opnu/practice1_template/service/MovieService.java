package ua.opnu.practice1_template.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.entities.Movie;
import ua.opnu.practice1_template.repository.MovieRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
  private MovieRepository repo;

  @Autowired
  public MovieService(MovieRepository repo) {
    this.repo = repo;
  }

  public Movie addMovie(Movie movie) {
    return repo.save(movie);
  }

  public List<Movie> getAllMovies() {
    return repo.findAll();
  }

  public Movie updateMovie(Long id, Movie updatedMovie) {
    return repo.findById(id)
            .map(movie -> {
              movie.setTitle(updatedMovie.getTitle());
              movie.setDuration(updatedMovie.getDuration());
              movie.setGenre(updatedMovie.getGenre());
              return repo.save(movie);
            })
            .orElseThrow(() -> new RuntimeException("Такий фільм не знайдено"));
  }
  public void deleteMovie(Long id) {
    if (!repo.existsById(id)) {
      throw new RuntimeException("Не знайдено фільм з ID: " + id);
    }
    repo.deleteById(id);
  }

  public List<Movie> getMoviesByGenre(String genre) {
    return repo.findByGenre(genre);
  }

  public List<Integer> getAllDurations() {
    return repo.findAllDurations();
  }
}