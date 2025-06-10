package ua.opnu.practice1_template.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.entities.User;
import ua.opnu.practice1_template.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class AuthController {

  private final UserService userService;

  @PostMapping("/register")
  public ResponseEntity<User> registerUser(@RequestBody User user) {
    User registeredUser = userService.registerUser(user);
    return ResponseEntity.ok(registeredUser);
  }
  @GetMapping("/getAllUsers")
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return ResponseEntity.ok(users);
  }
  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

}
