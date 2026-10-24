package com.ex04;

import com.ex01.Group;
import com.ex01.PieceType;
import com.ex01.Point;
import java.util.Objects;

public class Piece {

  private final Group group;
  private final PieceType PieceType;
  private final int hashcode;

  public Piece(Group group, PieceType PieceType, Point point) {
    this.group = group;
    this.PieceType = PieceType;
    hashcode = Objects.hash(group.code(), PieceType.code());
    System.out.println(hashcode);
    //    name += code;
  }

  public String name() {
    return group.name() + PieceType.name();
  }

  @Override
  public int hashCode() {
    return hashcode;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Piece) {
      Piece piece = (Piece) obj;
      return name().equals(piece.name());
    }
    return false;
  }
}
