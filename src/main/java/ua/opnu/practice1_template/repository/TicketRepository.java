package ua.opnu.practice1_template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.opnu.practice1_template.entities.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
  List<Ticket> findByScreening_Id(Long screeningId);
  long countByScreening_Movie_Id(Long movieId);

  @Query("SELECT COUNT(t) FROM Ticket t JOIN t.screening s " +
          "WHERE s.startTime BETWEEN :weekStart AND :weekEnd")
  Long countTicketsThisWeek(@Param("weekStart") LocalDateTime weekStart,
                            @Param("weekEnd") LocalDateTime weekEnd);

}
