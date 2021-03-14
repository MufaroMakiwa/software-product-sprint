package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@WebServlet("/contact-form-handler")
public class FormHandlerServlet extends HttpServlet {

  private final String NAME = "name";
  private final String EMAIL = "email";
  private final String SUBJECT = "subject";
  private final String MESSAGE = "message";
  private final String TIMESTAMP = "timestamp";


  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // get the user details from the form
    String name = Jsoup.clean(request.getParameter("name_input"), Whitelist.none());
    String email = Jsoup.clean(request.getParameter("email_input"), Whitelist.none());
    String subject = Jsoup.clean(request.getParameter("subject_input"), Whitelist.none());
    String message = Jsoup.clean(request.getParameter("message_input"), Whitelist.none());
   
    // add the message to datastore
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Message");
    
    FullEntity messageEntity = 
          Entity.newBuilder(keyFactory.newKey())
              .set(NAME, name)
              .set(EMAIL, email)
              .set(SUBJECT, subject)
              .set(MESSAGE, message)
              .set(TIMESTAMP, System.currentTimeMillis())
              .build();
    datastore.put(messageEntity);
    response.sendRedirect("/");
  }
}