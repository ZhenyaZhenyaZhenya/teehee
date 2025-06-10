package ua.opnu.practice1_template.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.entities.User;
import ua.opnu.practice1_template.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  public User registerUser(User user) {
    if (userRepository.existsByUsername(user.getUsername())) {
      throw new RuntimeException("Користувач із таким логіном вже існує.");
    }
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
