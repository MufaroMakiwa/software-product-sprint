package com.google.sps.servlets;

import com.google.gson.Gson;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  List<String> quotes = new ArrayList(List.of(
    "Red: If people were more kind and loving, then the world would be too.",  
    "Aram: I’m not saying I’m amazing, but sometimes I’m distinctly above average.",
    "Scottie: There’s a very fine line between love and hate."
  ));


  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/json");
    response.getWriter().println(convertToJson(quotes));
  }


  private String convertToJson(List<String> quotes) {
    Gson gson = new Gson();
    String arrayToJson = gson.toJson(quotes);
    return arrayToJson;
  } 
}
