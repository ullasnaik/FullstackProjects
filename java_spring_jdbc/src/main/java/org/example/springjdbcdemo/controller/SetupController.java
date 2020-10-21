package org.example.springjdbcdemo.controller;

import org.example.springjdbcdemo.exception.ServiceException;
import org.example.springjdbcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SetupController {
  @Autowired
  UserService userService;

  @RequestMapping("/")
  public String index() {
    try {
      this.userService.createTable();
    } catch (ServiceException e) {
      e.printStackTrace();
    }
    return "index";
  }
}
