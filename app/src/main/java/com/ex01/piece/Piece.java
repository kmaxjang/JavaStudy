package com.ex01.piece;

import com.ex01.Group;
import com.ex01.PieceType;
import com.ex01.Point;

public final class Piece {

  private final Group group;
  private final PieceType type;

  private int code;

  public Piece(Group group, PieceType type, Point point) {
    this.group = group;
    this.type = type;
    code = group.code() << 4 | type.code() << 7 | point.code();
  }

  public Group group() {
    return group;
  }

  public PieceType type() {
    return type;
  }

  @Override
  public int hashCode() {
    return code;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj instanceof Piece) {
      Piece piece = (Piece) obj;
      return piece.group() == group && piece.type == type;
    }
    return false;
  }

  @Override
  public String toString() {
    return "[" + group.toString() + type.toString() + "] Code: " + code;
  }
}
