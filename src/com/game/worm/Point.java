package com.game.worm;

public class Point {

  public int x;
  public int y;

  public Point() {
    this(0, 0);
  }

  public Point(Point p) {
    this(p.x, p.y);
  }

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Point move(int mx, int my) {
    x = x + mx;
    y = y + my;
    return this;
  }

  public Point move(Point mp) {
    move(mp.x, mp.y);
    return this;
  }

  public Point set(int sx, int sy) {
    x = sx;
    y = sy;
    return this;
  }

  public Point set(Point sp) {
    set(sp.x, sp.y);
    return this;
  }

  public Point get() {
    return new Point(this);
  }
}
