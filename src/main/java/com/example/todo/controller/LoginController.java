package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.todo.form.LoginForm;

@Controller
public class LoginController {
  
  @GetMapping( "/login" )
  public String showLogin( LoginForm form ) {
    return "login";
  }

}
