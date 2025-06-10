package ua.opnu.practice1_template.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.entities.Screening;
import ua.opnu.practice1_template.entities.Ticket;
import ua.opnu.practice1_template.repository.ScreeningRepository;
import ua.opnu.practice1_template.repository.TicketRepository;
import ua.opnu.practice1_template.stats.StatsDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketService {
  private final TicketRepository repo;
  private final ScreeningRepository screeningRepository;

  public Ticket purchaseTicket(Ticket ticket) {
    return repo.save(ticket);
  }

  public void returnTicket(Long id) {
    if (!repo.existsById(id)) {
      throw new RuntimeException("Не знайдено білет з ID: " + id);
    }
    repo.deleteById(id);
  }
  public List<Ticket> getTicketsByScreening(Long screeningId) {
    return repo.findByScreening_Id(screeningId);
  }

  public List<Integer> getAvailableSeats(Long screeningId) {
    Screening screening = screeningRepository.findById(screeningId)
            .orElseThrow(() -> new RuntimeException("Не знайдено сеанс з ID: " + screeningId));
    int totalSeats = screening.getHall().getSeats();
    List<Ticket> bookedTickets = repo.findByScreening_Id(screeningId);
    Set<Integer> bookedSeats = bookedTickets.stream()
            .map(ticket -> {
              try {
                return Integer.valueOf(ticket.getSeatNumber());
              } catch (NumberFormatException e) {
                return null;
              }
            })
            .filter(Objects::nonNull)
            .collect(Collectors.toSet());
    List<Integer> availableSeats = new ArrayList<>();
    for (int i = 1; i <= totalSeats; i++) {
      if (!bookedSeats.contains(i)) {
        availableSeats.add(i);
      }
    }
    return availableSeats;
  }

  public long ticketsByMovie(Long movieId) {
    return repo.countByScreening_Movie_Id(movieId);
  }

  public double getMovieRevenue(Long movieId) {
    long soldTicketCount = ticketsByMovie(movieId);
    double ticketPrice = 140.0;
    return soldTicketCount * ticketPrice;
  }

  public StatsDTO getWeeklyStats() {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime weekAgo = now.minusDays(7);

    Long count = repo.countTicketsThisWeek(weekAgo, now);
    double revenue = count * 100.0;

    return new StatsDTO(count, revenue);
  }
}
