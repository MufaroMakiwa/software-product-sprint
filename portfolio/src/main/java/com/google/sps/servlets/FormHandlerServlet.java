package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contact-form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // get the user details from the form
    String name = request.getParameter("name-input");
    String email = request.getParameter("email-input");
    String subject = request.getParameter("subject-input");
    String message = request.getParameter("messagr-input");

    // Print the value so for the server logs.
    String userInput = "Name: " + name + ", Email: " + email + ", Subject: " + subject + ", Message: " + message;
    System.out.println(userInput);

    // Respond with the result.
    response.getWriter().println(userInput);
  }


  private String getParameter(HttpServletRequest request, String name) {
    return request.getParameter(name);
  }
}