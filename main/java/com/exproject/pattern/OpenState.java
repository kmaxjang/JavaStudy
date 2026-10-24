package com.exproject.pattern;

public class OpenState implements State {

  private static CloseState cs = new CloseState();

  public void open(Consider c) {
    System.out.println("열려있음");
  }

  public void close(Consider c) {
    System.out.println("닫음");
    c.setState(cs);
  }

}

