package com.game2.worm;
// 방향
public enum Way {
  UP(0, -1),
  DOWN(0, 1),
  LIFTE(-1, 0),
  RIGHT(1, 0);

  private Point move;

  private Way(int x, int y) {
    move = new Point(x, y);
  }

  public Point move(Way vector, Point np) {
    np.move(move);
    return np;
  }

  public Point move(Point nowp) {
    Point mp = nowp.get();
    mp.move(move);
    return mp;
  }
  // 역방향
  public Way wayBack() {
    switch (this) {
      case UP:
        return DOWN;
      case DOWN:
        return UP;
      case LIFTE:
        return RIGHT;
      case RIGHT:
        return LIFTE;
    }
    return null;
  }
// up
  public Way vector(Point a, Point b) {
    if (a.x == b.x) {
      return (a.y < b.y) ? Way.DOWN : Way.UP;
    } else {
      return (a.x < b.y) ? Way.RIGHT : Way.LIFTE;
    }
  }
}
