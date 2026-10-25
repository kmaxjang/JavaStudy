package com.game.janggi.ex.util;

// 좌표

public class Point {

  private static Point[] pointlist = new Point[9 * 10];

  {
    for (int code = 0; code < (9 * 10); code++) {
      pointlist[code] = new Point(code);
    }
  }

  public final int x;
  public final int y;
  public final int code;

  private Point(int code) {
    x = code / 10;
    y = code % 10;
    this.code = code;
  }

  public static Point in(int code) {
    return pointlist[code];
  }

  public static Point in(int x, int y) {
    return pointlist[(y * 10) + x];
  }

  public int x() {
    return x;
  }

  public int y() {
    return y;
  }

  public int code() {
    return code;
  }

  public boolean equals(Point p) {
    return this == p;
  }

  public boolean equals(int x, int y) {
    return (this.x == x && this.y == y);
  }

  public String toString() {
    return String.format("%d%d", x, y);
  }
}
