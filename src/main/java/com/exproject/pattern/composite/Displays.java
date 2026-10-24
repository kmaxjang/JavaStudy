package com.exproject.pattern.composite;

import java.util.Iterator;

import com.game.janggi.ex.Board;
import com.game.janggi.ex.interfacemod.Piece;
import com.game.janggi.ex.util.Point;

public class Displays {

  private StringBuffer mark = new StringBuffer();
  private final int maxx = 9;
  private final int maxy = 10;

  private int[][] board = new int[maxx][maxy];
  private boolean[][] mark_check = new boolean[maxx][maxy];

  private String mark_space = "⬛";
  private String mark_choice = "⭕";

  private Board exboard = new Board();

  public Displays() {
    reSetBoard();
  }

  private void reSetBoard() {
    for (int[] x : board) {
      for (int y : x) {
        y = 0;
      }
    }
  }

  public void displaysUpdata() {}

  public void moveableMark(boolean mark) {}

  public void screen() {
    mark.delete(0, mark.capacity());
    mark.append(" 1 2 3 4 5 6 7 8 9\n");
    for (int y = 0; y < maxy; y++) {
      mark.append((y + 1) % 10);
      for (int x = 0; x < maxx; x++) {     
        if (moveable(x, y)) {
          mark.append(mark_choice);
        }else {
          mark.append(getPiece(board[x][y]));
        // System.out.println("말" + board[x][y] + "x" + x + "y" + y);
        }
      }
      mark.append('\n');
    }
    System.out.println(mark);
  }

  public String getPiece(int piece) {
    switch (piece) {
      case 11:
        return "🦁";
      case 17:
        return "🐅";
      case 16:
        return "🦌";
      case 15:
        return "🐴";
      case 14:
        return "🐘";
      case 12:
        return "🐀";
      case 13:
        return "🐵";
      case 21:
        return "🤴";
      case 27:
        return "👮‍♂️";
      case 26:
        return "👨‍🚒";
      case 25:
        return "👨‍🍳";
      case 24:
        return "👨‍🔧";
      case 23:
        return "👨‍🏫";
      case 22:
        return "👨‍🌾";
    }
    return mark_space;
  }

  public void setPiece(Point p, int piece) {
    int x = p.getX();
    int y = p.getY();
    board[x][y] = piece;
  }

  public void setPieceMove(int x, int y, int mx, int my) {
    board[mx][my] = board[x][y];
    board[x][y] = 0;
  }

  public boolean moveable(int x, int y) {
    return mark_check[x][y];
  }

  public void m() {
    Iterator<Piece> list = exboard.getPieceList();
    while (list.hasNext()) {
      Piece piece = list.next();      
    }
  }

  public void move(Point p) {
    Piece piece = exboard.getPiece(p);
    if (piece != null) {
      Iterator<Point> moves = exboard.movable(piece);
      while (moves.hasNext()) {
        Point mp = moves.next();
        mark_check[mp.getX()][mp.getY()] = true;
      }
    }
  }

  public static void main(Piece[] args) {
    Displays ds = new Displays();

    ds.m();
    ds.screen();
    ds.move(new Point(0,0));
    ds.setPieceMove(4, 8, 4, 7);
    ds.screen();
  }
}
