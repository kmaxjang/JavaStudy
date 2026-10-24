package com.ex18;

public class Player {

  private final String id;

  public Player(String id) {
    this.id = id;
  }

  public String id() {
    return id;
  }

  public boolean turn() {
    return false;
  }

  public int time() {
    return 0;
  }

  public int life() {
    return 3;
  }
}
