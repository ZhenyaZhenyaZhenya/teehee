package ua.opnu.practice1_template.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.entities.Hall;
import ua.opnu.practice1_template.service.HallService;

import java.util.List;

@RestController
@RequestMapping("/halls")
@RequiredArgsConstructor
public class HallController {
  private final HallService service;

  @PostMapping("/addHall")
  public ResponseEntity<Hall> addHall(@RequestBody Hall hall) {
    Hall newHall = service.addHall(hall);
    return ResponseEntity.ok(newHall);
  }
  @GetMapping("/getAllHalls")
  public ResponseEntity<List<Hall>> getAllHalls() {
    List<Hall> halls = service.getAllHalls();
    return ResponseEntity.ok(halls);
  }
  @PutMapping("/updateHall/{id}")
  public ResponseEntity<Hall> updateHall(@PathVariable Long id, @RequestBody Hall updatedHall) {
    Hall hall = service.updateHall(id, updatedHall);
    return ResponseEntity.ok(hall);
  }
  @DeleteMapping("/deleteHall/{id}")
  public ResponseEntity<Void> deleteHall(@PathVariable Long id) {
    service.deleteHall(id);
    return ResponseEntity.noContent().build();
  }
}
