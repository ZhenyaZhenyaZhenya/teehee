package ua.opnu.practice1_template.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.entities.Screening;
import ua.opnu.practice1_template.service.ScreeningService;

import java.util.List;

@RestController
@RequestMapping("/screenings")
@RequiredArgsConstructor
public class ScreeningController {
  private final ScreeningService service;

  @PostMapping("/add")
  public ResponseEntity<Screening> createScreening(@RequestBody Screening screening) {
    Screening createdScreening = service.createScreening(screening);
    return ResponseEntity.ok(createdScreening);
  }
  @GetMapping("/movie/{movieId}")
  public ResponseEntity<List<Screening>> getScreeningsByMovie(@PathVariable Long movieId) {
    List<Screening> screenings = service.getScreeningsByMovie(movieId);
    return ResponseEntity.ok(screenings);
  }
  @PutMapping("/update/{id}")
  public ResponseEntity<Screening> updateScreening(
          @PathVariable Long id,
          @RequestBody Screening updatedScreening) {
    Screening updated = service.updateScreening(id, updatedScreening);
    return ResponseEntity.ok(updated);
  }
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteScreening(@PathVariable Long id) {
    service.deleteScreening(id);
    return ResponseEntity.noContent().build();
  }
}
