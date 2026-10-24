package com.exproject.pattern.composite;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Board {

  public final int minx = 0;
  public final int miny = 0;
  public final int maxx = 9;
  public final int maxy = 10;

  private int[][] board = new int[maxx][maxy];

  private List<String> record = new ArrayList<String>();

  private boolean updata = false;

  public Board() {
    reSet();
  }

  public void setDefaulteBatch(int han_masag, int cho_masag) {
    // 말 생성과 기본 배치
  }

  public void reSet() {
    for (int[] x : board) {
      for (int y : x) {
        y = 0;
      }
    }
  }

  public void move(Player player, Point movepoint) {}

  public int getPiece(Point p) {
    return getPiece(p.x, p.y);
  }

  public int getPiece(int x, int y) {
    return board[x][y];
  }

  public Iterator<String> getPieceData() {

    return new Iterator<String>() {

      public boolean hasNext() {
        return false;
      }

      public String next() {
        return null;
      }
    };
  }
}
