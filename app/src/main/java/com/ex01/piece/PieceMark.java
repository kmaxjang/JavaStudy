package com.ex01.piece;

import com.ex01.Group;
import com.ex01.PieceType;

public enum PieceMark {
  Han_King("한왕"),
  Han_Cha("한차"),
  Han_Poo("한포"),
  Han_Ma("한마"),
  Han_Sang("한상"),
  Han_Sa("한사"),
  Han_jol("한졸"),

  Cho_King("초왕"),
  Cho_Cha("초차"),
  Cho_Poo("초포"),
  Cho_Ma("초마"),
  Cho_Sang("초상"),
  Cho_Sa("초사"),
  Cho_Byeong("초병");

  public final String name;

  private PieceMark(String name) {
    this.name = name;
  }

  public Group group() {
    return ordinal() < 7 ? Group.HAN : Group.CHO;
  }

  public PieceType type() {
    return PieceType.of(ordinal() % 7);
  }

  public boolean isGroup(PieceMark piece) {
    return piece.group() == group();
  }

  public boolean isType(PieceMark piece) {
    return piece.type() == type();
  }
}
