package com.ex01;

import com.ex01.Code;
import com.ex01.Point;
import com.ex01.Board;
import com.ex01.Castle;
import com.ex01.Direction;
import com.ex01.Group;
import com.ex01.Piece;

/** Piece 의 요소 */
public enum PieceType implements Code {
  KING {
    public void moveCheck(Point nowpoint, Board board) {
      castleMove(nowpoint, board);
    }
  },
  CHA {
    public void moveCheck(Point nowpoint, Board board) {
      Point mpoint;
      Direction way;
      for (int i = 0; i < 4; i++) {
        mpoint = nowpoint;
        way = Direction.orthogonal(i);
        while ((mpoint = mpoint.move(way)) != null) {
          if (board.pieceCheck(mpoint)) {
            break;
          }
        }
      }
      switch (Castle.getType(nowpoint)) {
        case Center:
          for (int i = 0; i < 4; i++) {
            mpoint = nowpoint.move(Direction.diagonal(i));
            board.pieceCheck(mpoint);
          }
          break;
        case Edge:
          way = Castle.Edge.direction(nowpoint);
          mpoint = nowpoint.move(way);
          if (!board.pieceCheck(mpoint)) {
            board.pieceCheck(mpoint.move(way));
          }
      }
    }
  },
  POO {
    public void moveCheck(Point nowpoint, Board board) {
      Point mpoint;
      Direction way;
      for (int i = 0; i < 4; i++) {
        mpoint = nowpoint;
        way = Direction.orthogonal(i);
        NEXT:
        while (pooMoveRange(mpoint, way)) {
          mpoint = mpoint.move(way);
          if (board.isPiece(mpoint)) {
            if (board.getPiece(mpoint).type().isPOO()) break;
            while ((mpoint = mpoint.move(way)) != null) {
              if (board.pooCheck(mpoint)) {
                break NEXT;
              }
            }
          }
        }
      }
      if (Castle.Edge.contains(nowpoint)) {
        way = Castle.Edge.direction(nowpoint);
        mpoint = nowpoint.move(way);
        if (board.isPiece(mpoint) && !board.getPiece(mpoint).type().isPOO()) {
          mpoint = mpoint.move(way);
          board.pooCheck(mpoint);
        }
      }
    }
    // 포 최소 이동거리
    public boolean pooMoveRange(Point p, Direction way) {
      switch (way) {
        case UP:
          return p.y > 1;
        case LEFT:
          return p.x < 7;
        case RIGHT:
          return p.x > 1;
        case DOWN:
          return p.y < 8;
      }
      return false;
    }
  },
  MA {
    public void moveCheck(Point nowpoint, Board board) {
      Point mpoint;
      Direction way;
      boolean route = false, route1 = false, route2 = false;
      for (int i = 0; i < 4; i++) {
        way = Direction.orthogonal(i);
        // 최소거리 확인
        switch (way) {
          case UP:
            route = nowpoint.y > 1;
            route1 = nowpoint.x > 0;
            route2 = nowpoint.x < 7;
            break;
          case LEFT:
            route = nowpoint.x < 7;
            route1 = nowpoint.y > 0;
            route2 = nowpoint.y < 9;
            break;
          case DOWN:
            route = nowpoint.y < 8;
            route1 = nowpoint.x > 0;
            route2 = nowpoint.x < 7;
            break;
          case RIGHT:
            route = nowpoint.x > 1;
            route1 = nowpoint.y > 0;
            route2 = nowpoint.y < 9;
        }

        mpoint = nowpoint.move(way);
        if (route && !board.isPiece(mpoint)) {
          if (route1) board.pieceCheck(mpoint.move(way.cw()));
          if (route2) board.pieceCheck(mpoint.move(way.ccw()));
        }
      }
    }
  },
  SANG {
    public void moveCheck(Point nowpoint, Board board) {
      Point mpoint;
      Direction way;
      boolean route = false, route1 = false, route2 = false;
      for (int i = 0; i < 4; i++) {
        way = Direction.orthogonal(i);
        // 최소거리 확인
        switch (way) {
          case UP:
            route = nowpoint.y > 2;
            route1 = nowpoint.x > 2;
            route2 = nowpoint.x < 5;
            break;
          case LEFT:
            route = nowpoint.x < 5;
            route1 = nowpoint.y > 2;
            route2 = nowpoint.y < 7;
            break;
          case DOWN:
            route = nowpoint.y < 7;
            route1 = nowpoint.x > 2;
            route2 = nowpoint.x < 5;
            break;
          case RIGHT:
            route = nowpoint.x > 2;
            route1 = nowpoint.y > 2;
            route2 = nowpoint.y < 7;
        }
        mpoint = nowpoint.move(way);
        if (route && !board.isPiece(mpoint)) {
          if (route1 && !board.isPiece(mpoint.move(way.cw()))) {
            board.pieceCheck(mpoint.move(way.cw(), way.cw()));
          }
          if (route2 && !board.isPiece(mpoint.move(way.ccw()))) {
            board.pieceCheck(mpoint.move(way.ccw(), way.ccw()));
          }
        }
      }
    }
  },
  SA {
    public void moveCheck(Point nowpoint, Board board) {
      castleMove(nowpoint, board);
    }
  },
  JOL {
    public void moveCheck(Point nowpoint, Board board) {

      boolean group = board.getPiece(nowpoint).group().isHAN();
      int start = group ? 1 : 3;
      for (int i = start; i < 3 + start; i++) {
        board.pieceCheck(nowpoint.move(Direction.orthogonal(i)));
      }
      switch (Castle.getType(nowpoint)) {
        case Center:
          for (int i = start; i < 2 + start; i++) {
            board.pieceCheck(nowpoint.move(Direction.diagonal(i)));
          }
          break;
        case Edge:
          Direction way = Castle.Edge.direction(nowpoint);
          switch (way) {
            case UPLEFT:
            case UPRIGHT:
              if (!group) {
                board.pieceCheck(nowpoint.move(way));
              }
              break;
            case DOWNLEFT:
            case DOWNRIGHT:
              if (group) {
                board.pieceCheck(nowpoint.move(way));
              }
              break;
          }
      }
    }
  };

  public static final PieceType[] MAP = values();

  public abstract void moveCheck(Point nowpoint, Board board);

  public boolean isPOO() {
    return this == POO;
  }

  @Override
  public int code() {
    return ordinal();
  }

  public static PieceType of(int code) {
    return MAP[code];
  }

  private static void castleMove(Point nowpoint, Board board) {
    Direction way = Direction.UP;
    switch (Castle.getType(nowpoint)) {
      case Center:
        for (int i = 0; i < 8; i++) {
          board.pieceCheck(nowpoint.move(way.spin(i)));
        }
        break;
      case Edge:
        way = Castle.Edge.direction(nowpoint);
        for (int i = 0; i < 3; i++) {
          board.pieceCheck(nowpoint.move(way.orthogonal(i)));
        }
        break;
      case Wall:
        way = Castle.Wall.direction(nowpoint).ccw();
        for (int i = 0; i < 3; i++) {
          board.pieceCheck(nowpoint.move(way.spin(i)));
        }
    }
  }
}
