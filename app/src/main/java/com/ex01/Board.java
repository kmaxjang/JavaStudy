package com.ex01;

import com.ex01.PiecePath;
import com.ex01.Group;
import com.ex01.Piece;
import com.ex01.Point;
import com.ex01.SangPath;
import java.util.HashMap;
import java.util.Map;
import static com.ex01.Direction.*;
import static com.ex01.Massge.*;

public class Board {

  private Map<Point, Piece> piece_map;
   
  private Group nowturn = Group.CHO;

  public Board() {
    piece_map = new HashMap<>();
    piece_map = PiecePath.defaultBuild(SangPath.MSMS, SangPath.SMMS);

    piece_map.remove(null);
    print("=======================");
    for (Point p : piece_map.keySet()) {
      print(p + " " + piece_map.get(p));
    }
    print("=======================");
  }

  public Board(Map<Point, Piece> map) {
    if (map == null || map.isEmpty()) {
      throw new NullPointerException("장기말 없음");
    }
    piece_map = map;

    piece_map.remove(null);
    print("=======================");
    for (Point p : piece_map.keySet()) {
      print(p + " " + piece_map.get(p));
    }
    print("=======================");
  }

  public boolean isPiece(Point point) {
    return piece_map.containsKey(point);
  }

  public boolean isPiece(Point point, Piece piece) {
    return getPiece(point) == piece;
  }

  public boolean isPiece(Point point, Group group, PieceType type) {
    return getPiece(point) == Piece.of(group, type);
  }

  public Piece getPiece(Point point) {
    return piece_map.get(point);
  }
  
  public Map<Point,String> getPiecePath(){
    Map<Point, String> path = new HashMap<>();
    for(Point p: piece_map.keySet()){
      path.put(p,piece_map.get(p).name);
    }
    return path;
  }

  public void chackmate(Point kingpoint, Piece king) {
    Point cpoint = kingpoint;
    Direction way;
    Group enemy = king.enemy();
    Piece enemycha = Piece.of(enemy, PieceType.CHA);
    Piece enemypoo = Piece.of(enemy, PieceType.POO);
    Piece enemyma = Piece.of(enemy, PieceType.MA);
    Piece enemysang = Piece.of(enemy, PieceType.SANG);
    Piece enemyjol = Piece.of(enemy, PieceType.JOL);
    print(king + " " + kingpoint);
    // cha
    // poo
    for (int i = 0; i < 4; i++) {
      cpoint = kingpoint;
      way = Direction.orthogonal(i);
      while ((cpoint = cpoint.move(way)) != null) {
        if (isPiece(cpoint)) {
          if (isPiece(cpoint, enemycha)) {
            print("차장 " + cpoint);
            // 차장
          }
          if (!getPiece(cpoint).type().isPOO()) {
            while ((cpoint = cpoint.move(way)) != null) {
              if (isPiece(cpoint)) {
                if (isPiece(cpoint, enemypoo)) {
                  print("포장 " + cpoint);
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
    // Castle
    switch (Castle.getType(kingpoint)) {
      case Center:
        for (int i = 0; i < 4; i++) {
          cpoint = kingpoint.move(Direction.diagonal(i));
          if (isPiece(cpoint, enemycha)) {
            print("차장 " + cpoint);
            // 차장
          }
        }
        break;
      case Edge:
        way = Castle.Edge.direction(kingpoint);
        cpoint = kingpoint.move(way);
        if (isPiece(cpoint)) {
          Piece piece = getPiece(cpoint);
          if (piece == enemycha) {
            print("차장 " + cpoint);
            // 차장
          } else if (piece.type().isPOO()) {
            break;
          }
          if (isPiece(cpoint.move(way), enemypoo)) {
            print("포장 " + cpoint);
            // 포장
          }
        } else if (isPiece(cpoint.move(way), enemycha)) {
          print("차장 " + cpoint);
          // 차장
        }
    }
    // ma
    // sang
    for (int i = 0; i < 4; i++) {
      way = Direction.diagonal(i);
      if ((cpoint = kingpoint.move(way)) != null && !isPiece(cpoint)) {
        if (isPiece(cpoint.move(way.cw()), enemyma)) {
          print("마장 " + cpoint.move(way.cw()));
          // 마장
        }
        if (isPiece(cpoint.move(way.ccw()), enemyma)) {
          print("마장 " + cpoint.move(way.ccw()));
          // 마장
        }
        if ((cpoint = cpoint.move(way)) != null && !isPiece(cpoint)) {
          if (isPiece(cpoint.move(way.cw()), enemysang)) {
            print("상장 " + cpoint.move(way.cw()));
            // 상장
          }
          if (isPiece(cpoint.move(way.ccw()), enemysang)) {
            print("상장 " + cpoint.move(way.ccw()));
            // 상장
          }
        }
      }
    }

    // jol
    boolean forward = enemy.isHAN();
    int start = forward ? 3 : 1; // ㅗ v : ㅜ ㅅ
    for (int i = 0; i < 3; i++) {
      cpoint = kingpoint.move(Direction.orthogonal(i + start));
      if (isPiece(cpoint, enemyjol)) {
        print("졸장 " + cpoint);
        // 졸장
      }
    }
    switch (Castle.getType(kingpoint)) {
      case Center:
        for (int i = 0; i < 2; i++) {
          cpoint = kingpoint.move(Direction.diagonal(i + start));
          if (isPiece(cpoint, enemyjol)) {
            print("졸장 " + cpoint + " way:" + Direction.diagonal(i + start));
            // 졸장
          }
        }
        break;
      case Edge:
        way = Castle.Edge.direction(kingpoint);
        switch (way) {
          case UPLEFT:
          case UPRIGHT:
            break;
          case DOWNLEFT:
          case DOWNRIGHT:
            forward = !forward;
            break;
        }
        if (forward) {
          if (isPiece(kingpoint.move(way), enemyjol)) {
            print("졸장 " + kingpoint.move(way) + " way:" + way);
            // 졸장
          }
        }
    }
  }
  
   public boolean pieceCheck(Point mpoint) {

    if (!isPiece(mpoint)) {
      // 공백기록 move
      return false;
    }
    Piece target = getPiece(mpoint);
    if (target.isGroup(nowturn)) {
      // 같은편 기록 support
    } else {
      // target
      // 적군 기록 take
    }
    return true;
  }

  public boolean pooCheck(Point mpoint) {
    if (!isPiece(mpoint)) {
      // 공백기록 move
      return false;
    }
    Piece target = getPiece(mpoint);
    if (target.type().isPOO()) {
      // 포 기록
    } else if (target.isGroup(nowturn)) {
      // 같은편 기록 support
    } else {
      // 적군 기록 take
    }
    return true;
  }

}
