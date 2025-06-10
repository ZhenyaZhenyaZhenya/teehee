package ua.opnu.practice1_template.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.entities.Screening;
import ua.opnu.practice1_template.repository.ScreeningRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreeningService {
  private final ScreeningRepository screeningRepository;

  public Screening createScreening(Screening screening) {
    return screeningRepository.save(screening);
  }
  public List<Screening> getScreeningsByMovie(Long movieId) {
    return screeningRepository.findByMovie_Id(movieId);
  }
  public Screening updateScreening(Long id, Screening updatedScreening) {
    Screening existingScreening = screeningRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Не знайдено сеанс з ID: " + id));
    existingScreening.setMovie(updatedScreening.getMovie());
    existingScreening.setHall(updatedScreening.getHall());
    existingScreening.setStartTime(updatedScreening.getStartTime());
    return screeningRepository.save(existingScreening);
  }
  public void deleteScreening(Long id) {
    if (!screeningRepository.existsById(id)) {
      throw new RuntimeException("Не знайдено сеанс з ID: " + id);
    }
    screeningRepository.deleteById(id);
  }
}
