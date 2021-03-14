package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import com.google.sps.data.Message;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list-messages")
public class ListMessagesServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Query<Entity> query = Query.newEntityQueryBuilder().setKind("Message").setOrderBy(OrderBy.desc("timestamp"))
        .build();
    QueryResults<Entity> results = datastore.run(query);

    List<Message> messages = new ArrayList<>();
    while (results.hasNext()) {

      // get the fields for all the entered messages
      Entity entity = results.next();
      long id = entity.getKey().getId();

      // create a message object from the messages entered by users
      String name = entity.getString("name");
      String email = entity.getString("email");
      String subject = entity.getString("subject");
      String message = entity.getString("message");
      final Message messageObj = new Message(name, email, subject, message);

      // add message to the list of all the other messages
      messages.add(messageObj);
    }
    System.out.println(messages);

    // send data to the client
    Gson gson = new Gson();
    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(messages));
  }
}