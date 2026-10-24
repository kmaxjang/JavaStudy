package com.ex01;

import com.ex01.Direction;
import com.ex01.Group;
import com.ex01.Piece;
import com.ex01.PieceType;
import com.ex01.Point;
import com.ex01.SangPath;
import java.util.HashMap;
import java.util.Map;

public class PiecePath {

  public static Map<Point, Piece> defaultBuild(SangPath han, SangPath cho) {
    Map<Point, Piece> piece_map = new HashMap<>();

    piece_map.put(Point.of(0, 0), Piece.Han_Cha);
    piece_map.put(Point.of(1, 0), Piece.of(Group.HAN, han.layout[0]));
    piece_map.put(Point.of(2, 0), Piece.of(Group.HAN, han.layout[1]));
    piece_map.put(Point.of(3, 0), Piece.Han_Sa);
    piece_map.put(Point.of(5, 0), Piece.Han_Sa);
    piece_map.put(Point.of(6, 0), Piece.of(Group.HAN, han.layout[2]));
    piece_map.put(Point.of(7, 0), Piece.of(Group.HAN, han.layout[3]));
    piece_map.put(Point.of(8, 0), Piece.Han_Cha);
    piece_map.put(Point.of(4, 1), Piece.Han_King);
    piece_map.put(Point.of(1, 2), Piece.Han_Po);
    piece_map.put(Point.of(7, 2), Piece.Han_Po);
    piece_map.put(Point.of(0, 3), Piece.Han_Jol);
    piece_map.put(Point.of(2, 3), Piece.Han_Jol);
    piece_map.put(Point.of(4, 3), Piece.Han_Jol);
    piece_map.put(Point.of(6, 3), Piece.Han_Jol);
    piece_map.put(Point.of(8, 3), Piece.Han_Jol);

    piece_map.put(Point.of(0, 9), Piece.Cho_Cha);
    piece_map.put(Point.of(1, 9), Piece.of(Group.CHO, cho.layout[0]));
    piece_map.put(Point.of(2, 9), Piece.of(Group.CHO, cho.layout[1]));
    piece_map.put(Point.of(3, 9), Piece.Cho_Sa);
    piece_map.put(Point.of(5, 9), Piece.Cho_Sa);
    piece_map.put(Point.of(6, 9), Piece.of(Group.CHO, cho.layout[2]));
    piece_map.put(Point.of(7, 9), Piece.of(Group.CHO, cho.layout[3]));
    piece_map.put(Point.of(8, 9), Piece.Cho_Cha);
    piece_map.put(Point.of(4, 8), Piece.Cho_King);
    piece_map.put(Point.of(1, 7), Piece.Cho_Po);
    piece_map.put(Point.of(7, 7), Piece.Cho_Po);
    piece_map.put(Point.of(0, 6), Piece.Cho_Jol);
    piece_map.put(Point.of(2, 6), Piece.Cho_Jol);
    piece_map.put(Point.of(4, 6), Piece.Cho_Jol);
    piece_map.put(Point.of(6, 6), Piece.Cho_Jol);
    piece_map.put(Point.of(8, 6), Piece.Cho_Jol);

    return piece_map;
  }

  public static Map<Point, Piece> masangTestBuild(Point kingpoint, Piece king) {
    // ma,sang test
    Map<Point, Piece> piece_map = new HashMap<>();
    piece_map.put(kingpoint, king);
    for (int i = 0; i < 4; i++) {
      Direction way = Direction.diagonal(i);
      piece_map.put(kingpoint.move(way, way.cw()), Piece.of(king.enemy(), PieceType.MA));
      piece_map.put(kingpoint.move(way, way.ccw()), Piece.of(king.enemy(), PieceType.MA));
      piece_map.put(kingpoint.move(way, way, way.cw()), Piece.of(king.enemy(), PieceType.SANG));
      piece_map.put(kingpoint.move(way, way, way.ccw()), Piece.of(king.enemy(), PieceType.SANG));
    }
    piece_map.remove(null);
    return piece_map;
  }

  public static Map<Point, Piece> jolTestBuild(Point kingpoint, Piece king) {
    Map<Point, Piece> piece_map = new HashMap<>();
    piece_map.put(kingpoint, king);
    // Jol test
    for (int i = 0; i < 8; i++)
      piece_map.put(kingpoint.move(Direction.UP.spin(i)), Piece.of(king.enemy(), PieceType.JOL));

    piece_map.remove(null);
    return piece_map;
  }

  public static Map<Point, Piece> chaTestBuild(Point kingpoint, Piece king) {
    Map<Point, Piece> piece_map = new HashMap<>();
    piece_map.put(kingpoint, king);
    // cha test
    for (int i = 0; i < 8; i++) {
      Direction way = Direction.UP.spin(i);
      Point cpoint = kingpoint.move(way);
      if (cpoint == null) continue;
      while (true) {
        if (cpoint.move(way) == null) {
          piece_map.put(cpoint, Piece.of(king.enemy(), PieceType.CHA));
          break;
        }
        cpoint = cpoint.move(way);
      }
    }
    piece_map.remove(null);
    return piece_map;
  }

  public static Map<Point, Piece> pooTestBuild(Point kingpoint, Piece king, Piece hurdle) {
    Map<Point, Piece> piece_map = new HashMap<>();
    piece_map.put(kingpoint, king);
    // poo test
    for (int i = 0; i < 8; i++) {
      Direction way = Direction.UP.spin(i);
      Point cpoint = kingpoint.move(way);
      if (cpoint == null) continue;
      piece_map.put(cpoint,hurdle);
      while (true) {
        if (cpoint.move(way) == null) {
          piece_map.put(cpoint, Piece.of(king.enemy(), PieceType.POO));
          break;
        }
        cpoint = cpoint.move(way);
      }
    }

    piece_map.remove(null);
    return piece_map;
  }
}
