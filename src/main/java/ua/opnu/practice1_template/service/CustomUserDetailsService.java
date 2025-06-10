package ua.opnu.practice1_template.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.entities.User;
import ua.opnu.practice1_template.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User appUser = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Користувач не знайдений: " + username));

    return org.springframework.security.core.userdetails.User
            .withUsername(appUser.getUsername())
            .password(appUser.getPassword())
            .roles("USER")
            .build();
  }
}
