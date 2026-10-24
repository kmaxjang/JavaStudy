package com.ex01;

import com.ex01.Board;
import com.ex01.Direction;
import com.ex01.Group;
import com.ex01.Piece;
import com.ex01.Point;

public class ChackMate {

  public void chackmate(Piece king, Point kingpoint, Board board) {
    Point cpoint = kingpoint;
    Direction way;
    Group enemy = king.enemy();
    Piece enemycha = Piece.of(enemy, PieceType.CHA);
    Piece enemypoo = Piece.of(enemy, PieceType.POO);
    Piece enemyma = Piece.of(enemy, PieceType.MA);
    Piece enemysang = Piece.of(enemy, PieceType.SANG);
    Piece enemyjol = Piece.of(enemy, PieceType.JOL);

    // cha
    // poo
    for (int i = 0; i < 4; i++) {
      cpoint = kingpoint;
      way = Direction.orthogonal(i);
      while ((cpoint = cpoint.move(way)) != null) {
        if (board.isPiece(cpoint)) {
          if (board.isPiece(cpoint, enemycha)) {
            // 차장
          }
          if (!board.getPiece(cpoint).type().isPOO()) {
            while ((cpoint = cpoint.move(way)) != null) {
              if (board.isPiece(cpoint)) {
                if (board.isPiece(cpoint, enemypoo)) {
                  // 포장
                }
                break;
              }
            }
          }
          break;
        }
      }
    }
    switch (Castle.getType(kingpoint)) {
      case Center:
        for (int i = 0; i < 4; i++) {
          cpoint = kingpoint.move(Direction.diagonal(i));
          if (board.isPiece(cpoint, enemycha)) {
            // 차장
          }
        }
        break;
      case Edge:
        way = Castle.Edge.direction(kingpoint);
        cpoint = kingpoint.move(way);
        if (board.isPiece(cpoint)) {
          Piece piece = board.getPiece(cpoint);
          if (piece == enemycha) {
            // 차장
          } else if (piece.type().isPOO()) {
            break;
          }
          if (board.isPiece(cpoint.move(way), enemypoo)) {
            // 포장
          }
        } else if (board.isPiece(cpoint.move(way), enemycha)) {
          // 차장
        }
    }
    // ma
    // sang
    for (int i = 0; i < 4; i++) {
      way = Direction.diagonal(i);
      if ((cpoint = kingpoint.move(way)) != null && !board.isPiece(cpoint)) {
        if (board.isPiece(cpoint.move(way.cw()), enemyma)) {
          // 마장
        }
        if (board.isPiece(cpoint.move(way.ccw()), enemyma)) {
          // 마장
        }
        if ((cpoint = cpoint.move(way)) != null && !board.isPiece(cpoint)) {
          if (board.isPiece(cpoint.move(way.cw()), enemysang)) {
            // 상장
          }
          if (board.isPiece(cpoint.move(way.ccw()), enemysang)) {
            // 상장
          }
        }
      }
    }

    // jol
    boolean forward = enemy.isHAN();
    int start = forward ? 3 : 1; // ㅗ ㅅ : ㅜ v
    for (int i = 0; i < 3; i++) {
      cpoint = kingpoint.move(Direction.orthogonal(i + start));
      if (board.isPiece(cpoint, enemyjol)) {
        // 졸장
      }
    }
    switch (Castle.getType(kingpoint)) {
      case Center:
        for (int i = 0; i < 2; i++) {
          cpoint = kingpoint.move(Direction.diagonal(i + start));
          if (board.isPiece(cpoint, enemyjol)) {
            // 졸장
          }
        }
        break;
      case Edge:
        way = Castle.Edge.direction(kingpoint);
        switch (way) {
          case UPLEFT:
          case UPRIGHT:
            forward = !forward;
            break;
          case DOWNLEFT:
          case DOWNRIGHT:
            break;
        }
        if (forward) {
          if (board.isPiece(kingpoint.move(way), enemyjol)) {
            // 졸장
          }
        }
    }
  }
}
