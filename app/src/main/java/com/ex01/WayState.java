package com.ex01;

import com.ex01.Piece;
import com.ex01.PieceType;
import com.ex01.Point;
import com.ex01.MoveState;
import java.util.HashMap;

public class WayState {

  private Piece piece = null;
  //  private HashMap<Point, Piece> piecelist = new HashMap();
  private HashMap<Point, MoveState> movestate = new HashMap<>();

  public boolean isMoveCheck(Piece movepiece) {
    if (piece != null) {
      if (piece == movepiece) {
        return false;
      }
      if (movepiece.type().isPOO() && piece.type().isPOO()) {
        return false;
      }
      if (movepiece.type() == PieceType.KING && movestate.containsValue(MoveState.SUPPORT)) {
        return false;
      }
    }
    return true;
  }
}
