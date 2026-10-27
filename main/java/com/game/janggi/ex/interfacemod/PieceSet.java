package com.game.janggi.ex.interfacemod;

import com.game.janggi.ex.interfacemod.Piece
import com.game.janggi.ex.util.Point;

// 장기말 기록 인터페이스
// 1 = 한
// 2 = 초
// 1 2 3 4 5 6 7
// 왕졸사상마포차

public interface PieceSet extends Piece {
  public enum PieceCode {
    GROUP(0), //
    TYPE(1), //
    POINT(2); //

    public final int CODE;

    private PieceCode(int code) {
      this.CODE = code;
    }
  };

  public Point getOldPosition(); // 전위치

  public Piece.Type takePiece(); // 잡은말
}
