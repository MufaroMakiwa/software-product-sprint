package com.google.sps.data;

public class Message {
  private final String name, email, subject, message;
  
  public Message(String name, String email, String subject, String message) {
    this.name = name;
    this.email = email;
    this.subject = subject;
    this.message = message;
  }
}