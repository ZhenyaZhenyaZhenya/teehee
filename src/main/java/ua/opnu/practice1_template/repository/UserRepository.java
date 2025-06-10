package ua.opnu.practice1_template.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.practice1_template.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

  boolean existsByUsername(String username);
  Optional<User> findByUsername(String username);
}
