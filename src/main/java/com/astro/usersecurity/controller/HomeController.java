package com.astro.usersecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  
  @GetMapping("/")
  public String home() {
    return "<h1>Welcome to My JWT Secured API</h1>"
         + "<p>Use Postman or your front-end app to interact with <code>/api/…</code> endpoints.</p>";
  }
}
