package com.ex04;

import com.ex01.Direction;
import com.ex01.Piece;
import com.ex01.Point;
import java.util.HashMap;

/*
보드 좌표 구성
*/

public final class Basket {

  // 현재좌표의 말 없으면 null
  private Piece piece = null;
  // 좌표에 지나가는 말 좌표
  private HashMap<Point, Direction> movepiece = new HashMap<>();
  // 지나가는 말 이동경로 포, 상, 마
  private HashMap<Point, Direction> waypiece = new HashMap<>();

  public Basket(Piece piece) {
    this.piece = piece;
    
  }

  public boolean isPiece() {
    return null != piece;
  }

  public Piece get() {
    if (piece != null) {
      Piece tmp = piece;
      piece = null;
      return tmp;
    }
    return piece;
  }

  public Piece set(Piece movepiece) {
    Piece tmp = piece;
    piece = movepiece;
    return tmp;
  }

  public void setMove(Point mp, Direction dir) {
    movepiece.put(mp, dir);
  }

  public void remove(Point mp) {
    movepiece.remove(mp);
    waypiece.remove(mp);
  }

  public boolean MoveChack() {
    return false;
  }

  // piece 변화
  // piece => null
  // 임시 이동 등록
  // 등록 movepiece 경로 다시계산 (장군인지 확인 반복)
  // 등록 waypiece 경로 다시계산 (장군인지 확인 반복)
  // null => piece
  // 등록 movepiece 경로 다시계산
  // 등록 waypiece 경로 다시계산 (포이면 장군인지 확인)
  // piece 이동좌표 basket 등록(장군인지 확인)

}
