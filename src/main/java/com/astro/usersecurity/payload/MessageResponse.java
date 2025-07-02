package com.astro.usersecurity.payload;

public class MessageResponse {
  private String message;

  public MessageResponse(String message) {
    this.message = "User registered successfully!";
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
