package com.exproject.pattern;

public class PatternTest {

  public static void main(String[] args) {

    Consider con = new Consider();

    con.open();
    con.close();

    con.close();
    con.open();

    con.open();
    con.close();
    con.close();
    con.close();
  }

}
