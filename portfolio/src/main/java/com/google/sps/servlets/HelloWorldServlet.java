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


  /**	
    [Source] https://gist.github.com/natebass/b0a548425a73bdf8ea5c618149fe1fce
  */  
  List<String> quotes = new ArrayList<>(List.of(
    "Life isn’t about getting and having, it’s about giving and being. : Kevin Kruse", 
    "Whatever the mind of man can conceive and believe, it can achieve. : Napoleon Hill", 
    "Strive not to be a success, but rather to be of value. : Albert Einstein", 
    "Two roads diverged in a wood, and I—I took the one less traveled by, And that has made all the difference. : Robert Frost", 
    "I attribute my success to this: I never gave or took any excuse. : Florence Nightingale", 
    "The most difficult thing is the decision to act, the rest is merely tenacity. : Amelia Earhart", 
    "Every strike brings me closer to the next home run. : Babe Ruth", 
    "Definiteness of purpose is the starting point of all achievement. : W. Clement Stone", 
    "We must balance conspicuous consumption with conscious capitalism. : Kevin Kruse", 
    "Life is what happens to you while you’re busy making other plans. : John Lennon", 
    "We become what we think about. : Earl Nightingale",
    "The most common way people give up their power is by thinking they don’t have any. : Alice Walker", 
    "The mind is everything. What you think you become. : Buddha", 
    "The best time to plant a tree was 20 years ago. The second best time is now. : Chinese Proverb", 
    "An unexamined life is not worth living. : Socrates", 
    "Eighty percent of success is showing up. : Woody Allen", 
    "Your time is limited, so don’t waste it living someone else’s life. : Steve Jobs", 
    "Winning isn’t everything, but wanting to win is. : Vince Lombardi",
     "I am not a product of my circumstances. I am a product of my decisions. : Stephen Covey", 
    "Every child is an artist.  The problem is how to remain an artist once he grows up. : Pablo Picasso",
    "The two most important days in your life are the day you are born and the day you find out why. : Mark Twain",
    "Whatever you can do, or dream you can, begin it.  Boldness has genius, power and magic in it. : Johann Wolfgang von Goethe", 
    "The best revenge is massive success. : Frank Sinatra", 
    "People often say that motivation doesn’t last. Well, neither does bathing.  That’s why we recommend it daily. : Zig Ziglar",
    "Life shrinks or expands in proportion to one’s courage. : Anais Nin", 
    "If you hear a voice within you say “you cannot paint,” then by all means paint and that voice will be silenced. : Vincent Van Gogh",
    "There is only one way to avoid criticism: do nothing, say nothing, and be nothing. : Aristotle",
    "Ask and it will be given to you; search, and you will find; knock and the door will be opened for you. : Jesus",
    "The only person you are destined to become is the person you decide to be. : Ralph Waldo Emerson", 
    "Go confidently in the direction of your dreams.  Live the life you have imagined. : Henry David Thoreau", 
    "Remember no one can make you feel inferior without your consent. : Eleanor Roosevelt", 
    "Life is what we make it, always has been, always will be. : Grandma Moses", 
    "The question isn’t who is going to let me; it’s who is going to stop me. : Ayn Rand", 
    "When everything seems to be going against you, remember that the airplane takes off against the wind, not with it. : Henry Ford",
    "It’s not the years in your life that count. It’s the life in your years. : Abraham Lincoln", 
    "Change your thoughts and you change your world. : Norman Vincent Peale", 
    "Either write something worth reading or do something worth writing. : Benjamin Franklin",
     "Nothing is impossible, the word itself says, “I’m possible!” : –Audrey Hepburn",
    "The only way to do great work is to love what you do. : Steve Jobs", 
    "If you can dream it, you can achieve it. : Zig Ziglar"
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
