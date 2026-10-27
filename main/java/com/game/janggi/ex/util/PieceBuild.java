package com.game.janggi.ex.util;

import com.game.janggi.ex.interfacemod.PieceSet.Group;
import com.game.janggi.ex.interfacemod.PieceSet.Type;
import com.game.janggi.ex.util.Point;

public class PieceBuild {

  private Group group;
  private Type type;
  private Point now;
  private Point old;
  private Type take = null;

  public void set(String piece) {
    group = Group.get(piece.substring(0, 1));
    type = Type.get(piece.substring(1, 2));
    now = Point.in(piece.substring(2, 4));
    old = Point.in(piece.substring(4, 6));
    int k = Integer.parseInt(piece.substring(6));
    take = (k == 0)? null:Type.get(piece.substring(6));
  }

  public Group group() {
    return group;
  }

  public Type type() {
    return type;
  }

  public Point position() {
    return now;
  }

  public Point oldPosition() {
    return old;
  }

  public Type takeType() {
    return take;
  }
  
  public Piece createPiece(int piece){
    return null;
  }
  
  public int createPieceCode(Piece piece, Point move, Type takepiece){
    return 0;
  }
}
