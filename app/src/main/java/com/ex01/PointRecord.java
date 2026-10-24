package com.ex01;

import com.ex01.Group;
import com.ex01.Piece;
import com.ex01.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class PointRecord {

  private Piece piece = null;
  private Map<Point, Object> hanstate = new HashMap<>();
  private Map<Point, Object> chostate = new HashMap<>();
  private Set<Piece> checkmate = new HashSet<>();

  public void setPiece(Piece piece) {
    this.piece = piece;
  }

  public Piece getPiece() {
    return piece;
  }

  public boolean isPiece() {
    return piece != null;
  }

  public void setMoveRecord(Point point, Group group, Object state) {
    if (group == Group.HAN) {
      hanstate.put(point, state);
    } else {
      chostate.put(point, state);
    }
  }

  public void moveRemove(Point point) {
    if (chostate.containsKey(point)) {
      chostate.remove(point);
    } else {
      hanstate.remove(point);
    }
  }
}
