package ua.opnu.practice1_template.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.entities.Ticket;
import ua.opnu.practice1_template.service.TicketService;
import ua.opnu.practice1_template.stats.StatsDTO;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
  private final TicketService service;

  @PostMapping("/buy")
  public ResponseEntity<Ticket> purchaseTicket(@RequestBody Ticket ticket) {
    Ticket purchasedTicket = service.purchaseTicket(ticket);
    return ResponseEntity.ok(purchasedTicket);
  }

  @DeleteMapping("/return/{id}")
  public ResponseEntity<Void> returnTicket(@PathVariable Long id) {
    service.returnTicket(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/screening/{screeningId}")
  public ResponseEntity<List<Ticket>> getTicketsByScreening(@PathVariable Long screeningId) {
    List<Ticket> tickets = service.getTicketsByScreening(screeningId);
    return ResponseEntity.ok(tickets);
  }

  @GetMapping("/available-seats/{screeningId}")
  public ResponseEntity<List<Integer>> getAvailableSeats(
          @PathVariable Long screeningId) {
    List<Integer> availableSeats = service.getAvailableSeats(screeningId);
    return ResponseEntity.ok(availableSeats);
  }

  @GetMapping("/ticketsSold/{movieId}")
  public ResponseEntity<Long> ticketsByMovie(@PathVariable Long movieId) {
    long count = service.ticketsByMovie(movieId);
    return ResponseEntity.ok(count);
  }

  @GetMapping("/movieRevenue/{movieId}")
  public ResponseEntity<Double> getMovieRevenue(@PathVariable Long movieId) {
    double revenue = service.getMovieRevenue(movieId);
    return ResponseEntity.ok(revenue);
  }

  @GetMapping("/statsWeek")
  public ResponseEntity<StatsDTO> getWeeklyStats() {
    StatsDTO stats = service.getWeeklyStats();
    return ResponseEntity.ok(stats);
  }
}
