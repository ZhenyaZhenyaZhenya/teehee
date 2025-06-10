package ua.opnu.practice1_template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.entities.Movie;
import ua.opnu.practice1_template.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
  private final MovieService service;

  @Autowired
  public MovieController(MovieService service) {
    this.service = service;
  }

  @PostMapping("/add")
  public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
    return ResponseEntity.ok(service.addMovie(movie));
  }

  @GetMapping("/getAllMovies")
  public ResponseEntity<List<Movie>> getAllMovies() {
    List<Movie> movies = service.getAllMovies();
    return ResponseEntity.ok(movies);
  }

  @PutMapping("/updateMovie/{id}")
  public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
    return ResponseEntity.ok(service.updateMovie(id, updatedMovie));
  }
  @DeleteMapping("/deleteMovie/{id}")
  public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
    service.deleteMovie(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/getByGenre/{genre}")
  public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre) {
    List<Movie> movies = service.getMoviesByGenre(genre);
    return ResponseEntity.ok(movies);
  }

  @GetMapping("/durations")
  public ResponseEntity<List<Integer>> getAllDurations() {
    List<Integer> durations = service.getAllDurations();
    return ResponseEntity.ok(durations);
  }
}
