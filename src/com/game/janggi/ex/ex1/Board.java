package com.game.janggi.ex.ex1;

import java.util.ArrayList;
import java.util.Iterator;

import com.game.janggi.ex.interfacemod.Piece;
import com.game.janggi.ex.interfacemod.PieceMove;
import com.game.janggi.ex.piece.Cha;
import com.game.janggi.ex.piece.Jol;
import com.game.janggi.ex.piece.King;
import com.game.janggi.ex.piece.Ma;
import com.game.janggi.ex.piece.PieceSet;
import com.game.janggi.ex.piece.Poo;
import com.game.janggi.ex.piece.Sa;
import com.game.janggi.ex.piece.Sag;
import com.game.janggi.ex.util.Point;

public class Board {

  private Point tmp = new Point(0, 0);
  // 장기말 목록
  private ArrayList<Piece> piece_list = new ArrayList<Piece>();
  private ArrayList<Piece> orderlist = new ArrayList<Piece>();
  // 장기판 크기
  public final int MIN_X = 0;
  public final int MIN_Y = 0;
  public final int MAX_X = 9;
  public final int MAX_Y = 10;
  // 한 궁좌표
  public final Point[] castleup = {
    new Point(3, 0),
    new Point(4, 0),
    new Point(5, 0),
    new Point(3, 1),
    new Point(4, 1),
    new Point(5, 1),
    new Point(3, 2),
    new Point(4, 2),
    new Point(5, 2),
  };
  // 초 궁좌표
  public final Point[] castledown = {
    new Point(3, 7),
    new Point(4, 7),
    new Point(5, 7),
    new Point(3, 8),
    new Point(4, 8),
    new Point(5, 8),
    new Point(3, 9),
    new Point(4, 9),
    new Point(5, 9),
  };
  private PieceMove pm = null;
  
  private int[] defaultpieceset = {
  1700000, 1612120, 1330300, 1141410, 1350500, 1672720, 1780800, 1203030, 1223230, 1243430,
  1263630, 1283830, 2709090, 2617170, 2339390, 2148480, 2359590, 2677770, 2789890, 2206060,
  2226260, 2246460, 2266660, 2286860
};
  public Board() {
      for (int pieceint : defaultpieceset) {
	setPiece(new PieceSet(pieceint));
	}
      
      int[] ma = {1410100, 1520200, 1460600, 1570700};
      int[] sag = {2419190, 2529290, 2469690, 2579790};
     
      for (int piece : ma) {
        setPiece(new PieceSet(piece));
      }
      
      for (int piece : sag) {
        setPiece(new PieceSet(piece));
      }     
  }

  public Piece getPiece(int x, int y) {
    tmp.set(x, y);
    return index(tmp);
  }

  public Piece getPiece(Point p) {
    return index(p);
  }

  private void setPiece(Piece piece) {
    if (piece != null) {
      piece_list.add(piece);
    }
  }

  public boolean setMove(Piece piece, Point move) {
    Iterator<Point> move_list = moveable(piece);
    while (move_list.hasNext()) {
      if (move_list.next().equals(move)) {
        Piece kill = index(move);
        if (kill != null) {
          piece_list.remove(kill);
        }
        piece.move(move, kill);
        orderlist.add(piece.info());
        return true;
      }
    }
    return false;
  }

  public Iterator<Piece> getPieceList() {
    return piece_list.iterator();
  }

  private Piece index(Point point) {
    for (Piece piece : piece_list) {
      if (piece.getPosition().equals(point)) {
        return piece;
      }
    }
    return null;
  }
  
  public Iterator<Point> moveable(Piece piece) {
      switch (piece.getPieceName()) {
	        case CHA:
	          pm = new Cha();
	          System.out.println("차");
	          break;
	        case POO:
	          pm = new Poo();
	           System.out.println("포");
	          break;
	        case MA:
	          pm = new Ma();
	           System.out.println("마");
	          break;
	        case SAG:
	          pm = new Sag();
	          System.out.println("상"); 
	          break;
	        case JOL:
	          pm = new Jol();
	           System.out.println("졸");
	          break;
	        case SA:
	          pm = new Sa();
	          System.out.println("사"); 
	          break;
	        case KING:
	          pm = new King();
	           System.out.println("왕");
	          break;
	      }
      return pm.moveable(this, piece);
  }
}
