package com.ex20;

import java.util.Map;

import com.ex01.Group;
import com.ex01.Point;
import com.ex01.Piece;

public abstract class AbstractBoard implements Board {

  private Group turn = Group.CHO;
  private Map<Point, Piece> piecemap;

  public AbstractBoard(Group turn, Map<Point, Piece> piecemap) {
    this.turn = (turn != Group.HAN) ? Group.CHO : Group.HAN;
    if (piecemap == null) {
      // err
    }
    this.piecemap = piecemap;
  }

  public Group nowTurn() {
    return turn;
  }
  
  public int count(){
    return 0;
  }
  
  public Point lastMove(){
    return null;
  }
  
  public boolean command(){
    return false;
  }

  public Map<Point, Piece> getPieceAllPosition() {
    return piecemap;
  }

  public boolean isPiece(Point point) {
    return piecemap.containsKey(point);
  }

  public Piece getPiece(Point point) {
    return piecemap.get(point);
  }
}
