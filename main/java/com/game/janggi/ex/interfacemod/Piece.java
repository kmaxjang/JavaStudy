package com.game.janggi.ex.interfacemod;

import com.game.janggi.ex.util.Point;

// 장기말 정의 인터페이스

public interface Piece {

  public enum Group {
    CHO(1), //
    HAN(2);

    public final int CODE;

    private Team(int code) {
      CODE = code;
    }

    public static Group get(int code) {
      switch (code) {
        case 1:
          return CHO;
        case 2:
          return HAN;
      }
      return null;
    }
  }

  public enum Type {
    KING(1), //
    JOL(2), //
    SA(3), //
    SAG(4), //
    MA(5), //
    POO(6), //
    CHA(7);

    public final int CODE;

    private Type(int code) {
      CODE = code;
    }

    public static Type get(int code) {
      switch (code) {
        case 1:
          return KING;
        case 2:
          return JOL;
        case 3:
          return SA;
        case 4:
          return SAG;
        case 5:
          return MA;
        case 6:
          return POO;
        case 7:
          return CHA;
      }
      return null;
    }
  }

  public Group group(); // 초 한
  
  public Type type(); // 장기말 왕 차 포 마 상 쫄(병) 사
  public Point getPosition(); // 현재위치

}
