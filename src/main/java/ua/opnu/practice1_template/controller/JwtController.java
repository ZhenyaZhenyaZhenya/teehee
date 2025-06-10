package ua.opnu.practice1_template.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.configs.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt/auth")
@RequiredArgsConstructor
public class JwtController {

  private final AuthenticationManager authenticationManager;
  private final JwtUtil jwtUtil;

  @PostMapping("/login")
  public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
    try {
      Authentication authentication = authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      loginRequest.getUsername(),
                      loginRequest.getPassword()
              )
      );
      String token = jwtUtil.generateToken(loginRequest.getUsername());
      return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    } catch (AuthenticationException ex) {
      return ResponseEntity.status(401).body("Невірний логін або пароль");
    }
  }

  @GetMapping("/protected")
  public ResponseEntity<String> protectedEndpoint() {
    return ResponseEntity.ok("JWT працює, доступ дозволено");
  }
}


class LoginRequest {
  private String username;
  private String password;
  public String getUsername() { return username; }
  public void setUsername(String username) { this.username = username; }
  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }
}

class JwtAuthenticationResponse {
  private String token;
  public JwtAuthenticationResponse(String token) { this.token = token; }
  public String getToken() { return token; }
  public void setToken(String token) { this.token = token; }
}
