package org.example.springormdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
  @GetMapping("/")
  public String loginPage() {
    return "login";
  }

  @GetMapping("/registerView")
  public String registerView() {
    return "register";
  }

}
