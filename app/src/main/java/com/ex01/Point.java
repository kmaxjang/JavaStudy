package com.ex01;

import com.ex01.Code;

public final class Point implements Code {

  public static final int MIN = 0;
  public static final int MAX_X = 9;
  public static final int MAX_Y = 10;

  public static final int MAX_CODE = MAX_X * MAX_Y;

  private static final Point[] MAP = new Point[MAX_CODE];
  static {
    for (int code = MIN; code < MAX_CODE; code++) {
      MAP[code] = new Point(code);
    }
  }
  
  public final int x;
  public final int y;
  public final int code;

  private Point(int code) {
    this.code = code;
    x = code % MAX_X;
    y = code / MAX_X;
 }

  public static boolean isBounds(int point, int min, int max) {
    return point >= min && point < max;
  }

  public static boolean isBounds(int x, int y) {
    return isBounds(x, MIN, MAX_X) && isBounds(y, MIN, MAX_Y);
  }

  public static boolean isCodeBounds(int code) {
    return code >= MIN && code < MAX_CODE;
  }

  public static int encode(int x, int y) {
    return x + (MAX_X * y);
  }

  public static Point of(int x, int y) {
    return isBounds(x, y) ? MAP[encode(x, y)] : null;
  }

  public static Point of(int code) {
    return isCodeBounds(code) ? MAP[code] : null;
  } 

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  @Override
  public int code() {
    return code;
  }

  public Point move(Direction move) {
    return of(x + move.dx, y + move.dy);
  }

  public Point move(Direction... move) {
    int mx = x;
    int my = y;
    for (Direction dpoint : move) {
      mx += dpoint.dx;
      my += dpoint.dy;
    }
    return of(mx, my);
  }

  @Override
  public int hashCode() {
    return code;
  }

  @Override
  public boolean equals(Object obj) {
    return this == obj;
  }

  @Override
  public String toString() {
    return "["+x+","+y+"] Code: "+code;
  }
}
