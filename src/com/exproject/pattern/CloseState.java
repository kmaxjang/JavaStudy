package com.exproject.pattern;

public class CloseState implements State {

  private static OpenState os = new OpenState();

  public void open(Consider c) {
    System.out.println("열음");
    c.setState(os);
  }

  public void close(Consider c) {
    System.out.println("닫혀있음");
  }

}
