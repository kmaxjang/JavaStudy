package com.game.janggi.ex.util;

// 이동좌표 계산
public enum Move {
  UP(0, -1), RIGHTUP(1, -1), RIGHT(1, 0), RIGHTDOWN(1, 1),
  DOWN(0,1), LEFTDOWN(-1, 1), LEFT(-1, 0), LEFTUP(-1, -1);

  public static final int min_x = 0;
  public static final int min_y = 0;

  public static final int max_x = 9;
  public static final int max_y = 10;

  public static final Move[] loop = { UP, RIGHT, DOWN, LEFT};
  
  private final int movex;
  private final int movey;

  private Move(int x, int y) {
    movex = x;
    movey = y;
  }

  public Point go(Point p) {
    int tmpx = p.x + movex;
    int tmpy = py + movey;
    if (tmpx < min_x || tmpx > max_x || tmpy < min_y || tmpy > max_y) {
      return null;
    }
    return Point.in(tmpx, tmpy);
  }
// p에서 move 만큼 이동후 범위판단
  public boolean isScope(Point p) {
    if(p == null) return false;
    return !(p.x + movex < min_x || p.x + movex > max_x || 
        py + movey < min_y || py + movey > max_y);
  }
}
