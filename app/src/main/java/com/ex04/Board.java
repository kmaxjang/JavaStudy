package com.ex04;

import com.ex01.Piece;
import com.ex01.Point;
import java.util.HashMap;

public final class Board {

  private Basket[] board = new Basket[Point.MAX_CODE];

  public Board(HashMap<Point, Piece> piecedata) {
    for (int i = 0; i < Point.MAX_CODE; i++) {
      board[i] = new Basket(piecedata.get(Point.of(i)));
    }
  }
}
