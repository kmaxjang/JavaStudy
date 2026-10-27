package com.game.janggi.ex.piece;

import java.util.Iterator;

import com.game.janggi.ex.interfacemod.Piece;
import com.game.janggi.ex.util.Point;

// 장기말 기본정의 Piece인터페이스 구현
public abstract class AbstractPiece implements Piece {

  public final Group group;
  public final Type type;

  public Piece(Group group, Type type) {
    this.group = group;
    this.type = type;
  }

  @Override
  public Group group() {
    return group;
  }

  @Override
  public Type type() {
    return type;
  }

  @Override
  public abstract Point getPosition();

  public boolean equals(Group group) {
    return this.group == group;
  }

  public boolean equals(Type type) {
    return this.type == type;
  }

  public boolean equals(Point position) {
    return getPosition() == position;
  }

  public String toString() {
    StringBuffer ts = new StringBuffer();
    ts.append(group == Group.HAN ? "한" : "초");
    if (type == Type.JOL) {
      ts.append(group == Group.HAN ? "졸" : "병");
    } else {
      ts.append(type.name());
    }
    return ts.toString();
  }
}
