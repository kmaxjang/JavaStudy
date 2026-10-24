package com.ex01;

import com.ex01.Code;
import com.ex01.Group;
import com.ex01.PieceType;
import java.util.Map;

public enum Piece implements Code {
  // 한
  Han_King("한왕"),
  Han_Cha("한차"),
  Han_Po("한포"),
  Han_Ma("한마"),
  Han_Sang("한상"),
  Han_Sa("한사"),
  Han_Jol("한졸"),
  // 초
  Cho_King("초왕"),
  Cho_Cha("초차"),
  Cho_Po("초포"),
  Cho_Ma("초마"),
  Cho_Sang("초상"),
  Cho_Sa("초사"),
  Cho_Jol("초병");

  public static final Piece[] MAP = values();
  private static final int type_count = PieceType.values().length;

  public static Piece of(int code) {
    return MAP[code];
  }

  public static Piece of(Group group, PieceType type) {
    return MAP[group.code() * type_count + type.code()];
  }

  public final String name;

  private Piece(String name) {
    this.name = name;
  }

  public Group group() {
    return Group.of(ordinal() / type_count);
  }

  public PieceType type() {
    return PieceType.of(ordinal() % type_count);
  }

  public boolean isGroup(Piece other) {
    return other.group() == this.group();
  }

  public boolean isGroup(Group other) {
    return other == this.group();
  }

  public boolean isType(Piece other) {
    return other.type() == this.type();
  }

  public boolean isType(PieceType other) {
    return other == this.type();
  }

  public Group enemy() {
    return group().enemy();
  }

  public boolean isPiece(Group other, PieceType type) {
    return isGroup(other) && isType(type);
  }

  @Override
  public int code() {
    return ordinal();
  }

  public Map<Point, Boolean> moveable() {
    return null;
  }
}
