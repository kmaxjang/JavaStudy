package com.ex11;

import java.util.HashMap;

public final class Piece {

  private String group;
  private String name;

  public String group() {
    return group;
  }

  public String name() {
    return name;
  }

  public HashMap<Point, Move> move() {
    return null;
  }
  
  public boolean move(Point point){
    return false;
  }
}
