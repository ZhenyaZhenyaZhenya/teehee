package ua.opnu.practice1_template.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.opnu.practice1_template.entities.User;
import ua.opnu.practice1_template.service.UserService;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

  private final UserService userService;

  @GetMapping("/register")
  public String showRegistrationForm(Model model) {
    model.addAttribute("user", new User());
    return "register";  // файл register.html у templates
  }

  @PostMapping("/register")
  public String registerUser(User user) {
    try {
      userService.registerUser(user);
    } catch (RuntimeException e) {
      return "redirect:/register?error";
    }
    return "redirect:/login?registered";
  }

  @GetMapping("/login")
  public String showLoginPage() {
    return "login";
  }
  @GetMapping("/greetings")
  public String greetings (Model model, OAuth2AuthenticationToken authentication) {
    model.addAttribute("userName", authentication.getPrincipal().getAttribute("name"));
    return "greetings";
  }


}
