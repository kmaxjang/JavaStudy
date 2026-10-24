package com.ex01;

import static com.ex01.Direction.*;
import com.ex01.Point;

public enum Castle {
  Center,
  Edge,
  Wall,
  None; // null 값 대용

  private static final Castle[] TYPE = {
    None, None, None, Edge, Wall, Edge, None, None, None, //
    None, None, None, Wall, Center, Wall, None, None, None, //
    None, None, None, Edge, Wall, Edge, None, None, None, //
    None, None, None, None, None, None, None, None, None, //
    None, None, None, None, None, None, None, None, None, //
    None, None, None, None, None, None, None, None, None, //
    None, None, None, None, None, None, None, None, None, //
    None, None, None, Edge, Wall, Edge, None, None, None, //
    None, None, None, Wall, Center, Wall, None, None, None, //
    None, None, None, Edge, Wall, Edge, None, None, None //
  };

  private static final Direction[] DIR = {
    null, null, null, DOWNLEFT, DOWN, DOWNRIGHT, null, null, null, //
    null, null, null, LEFT, UP, RIGHT, null, null, null, //
    null, null, null, UPLEFT, UP, UPRIGHT, null, null, null, //
    null, null, null, null, null, null, null, null, null, //
    null, null, null, null, null, null, null, null, null, //
    null, null, null, null, null, null, null, null, null, //
    null, null, null, null, null, null, null, null, null, //
    null, null, null, DOWNLEFT, DOWN, DOWNRIGHT, null, null, null, //
    null, null, null, LEFT, UP, RIGHT, null, null, null, //
    null, null, null, UPLEFT, UP, UPRIGHT, null, null, null,
  };

  public static Castle getType(Point p) {
    return TYPE[p.code()];
  }

  public static boolean isCastle(Point p) {
    return TYPE[p.code()] != None;
  }

  public boolean contains(Point p) {
    return this == TYPE[p.code()];
  }

  public Direction direction(Point p) {
    return DIR[p.code()];
  }
}
