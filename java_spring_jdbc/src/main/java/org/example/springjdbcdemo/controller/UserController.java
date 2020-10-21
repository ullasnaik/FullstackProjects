package org.example.springjdbcdemo.controller;

import org.example.springjdbcdemo.exception.ServiceException;
import org.example.springjdbcdemo.model.User;
import org.example.springjdbcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/v1")
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping("/loginView")
  public String loginView() {
    return "index";
  }

  @GetMapping("/registerView")
  public String registerView() {
    return "register";
  }

  @PostMapping("/register")
  public ModelAndView register(@RequestParam("username") String username, @RequestParam("password") String password) {
    try {
      this.userService.saveUser(new User(username, password));
      ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("dashboard");
      modelAndView.addObject("greeting", "Welcome");
      modelAndView.addObject("username", username);
      return modelAndView;
    } catch (ServiceException e) {
      System.out.println("Exception caught in controller");
      e.printStackTrace();
      return null;
    }
  }

  @PostMapping("/login")
  public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password) {
    try {
      User user = this.userService.getUserByUsernameAndPassword(username, password);
      ModelAndView modelAndView = new ModelAndView();
      if(user != null) {
        modelAndView.addObject("greeting", "Welcome");
        modelAndView.setViewName("dashboard");
      } else {
        modelAndView.setViewName("unauthenticated");
        modelAndView.addObject("errmsg", "Incorrect username or password.");
    }
      modelAndView.addObject("username", username);
      return modelAndView;
    } catch (ServiceException e) {
      System.out.println("Exception caught in controller");
      e.printStackTrace();
      return null;
    }
  }
}
