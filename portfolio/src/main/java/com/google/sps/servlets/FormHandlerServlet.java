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

    FullEntity messageEntity = Entity.newBuilder(keyFactory.newKey()).set("name", name).set("email", email)
        .set("subject", subject).set("message", message).set("timestamp", System.currentTimeMillis()).build();
    datastore.put(messageEntity);
    response.sendRedirect("/");
  }
}