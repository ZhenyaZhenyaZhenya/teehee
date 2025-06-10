package ua.opnu.practice1_template.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.entities.Hall;
import ua.opnu.practice1_template.repository.HallRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HallService {
  private final HallRepository repo;

  public Hall addHall(Hall hall) {
    return repo.save(hall);
  }

  public List<Hall> getAllHalls() {
    return repo.findAll();
  }
  public Hall updateHall(Long id, Hall updatedHall) {
    return repo.findById(id)
            .map(hall -> {
              hall.setName(updatedHall.getName());
              hall.setSeats(updatedHall.getSeats());
              return repo.save(hall);
            })
            .orElseThrow(() -> new RuntimeException("Не знайдено залу з ID: " + id));
  }
  public void deleteHall(Long id) {
    if (!repo.existsById(id)) {
      throw new RuntimeException("Не знайдено залу з ID: " + id);
    }
    repo.deleteById(id);
  }
}
