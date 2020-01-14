package com.game.worm;

public enum Way {
  UP(0, -1),
  DOWN(0, 1),
  LIFTE(-1, 0),
  RIGHT(1, 0);

  private Point move;

  private Way(int x, int y) {
    move = new Point(x, y);
  }

  public Point Move(Point np) {
    return np.move(move);
  }
}
