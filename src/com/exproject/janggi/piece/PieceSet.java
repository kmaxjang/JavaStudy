package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.util.Point;

// 장기말 기본정의 Piece인터페이스 구현
public abstract class PieceSet implements Piece {

  private char[] pieceinfo;
  private Point now_point = new Point(0, 0);

  public PieceSet(int piece) {
    this(String.valueOf(piece));
  }

  public PieceSet(String piece) {
    pieceinfo = piece.toCharArray();
  }

  @Override
  public boolean equalsTeam(Piece piece) {
    return getGroup().equals(piece.getGroup());
  }

  @Override
  public Group getGroup() {
    switch (pieceinfo[Info.TEAM.point]) {
      case '1':
        return Group.HAN;
      case '2':
        return Group.CHO;
    }
    return null;
  }

  @Override
  public PieceName getClassName() {
      return getClassName(Info.CLASS);
  }
  
  @Override
  public PieceName getKillClass(){      
      return getClassName(Info.KILL);
  }
  
  private PieceName getClassName(Info info) {
      switch (pieceinfo[info.point]) {
	      case '7':
	        return PieceName.CHA;
	      case '6':
	        return PieceName.POO;
	      case '5':
	        return PieceName.MA;
	      case '4':
	        return PieceName.SAG;
	      case '3':
	        return PieceName.SA;
	      case '2':
	        return PieceName.JOL;
	      case '1':
	        return PieceName.KING;
	    }
	    return null;
  }

  @Override
  public int info() {
      return Integer.valueOf(String.valueOf(pieceinfo));    
  }
  
  @Override
  public int parseInt(Info p) {
    return Integer.valueOf(pieceinfo[p.point]-0x30);
  }

  @Override
  public String parse(Info p) {
    return Character.toString(pieceinfo[p.point]);
  }

  @Override
  public boolean move(Point p, PieceName killpiece) {
    pieceinfo[Info.OLD_X.point] = pieceinfo[Info.NOW_X.point];
    pieceinfo[Info.OLD_Y.point] = pieceinfo[Info.NOW_Y.point];
    pieceinfo[Info.NOW_X.point] = (char)(p.x+0x30);
    pieceinfo[Info.NOW_Y.point] = (char)(p.y+0x30);

    pieceinfo[Info.KILL.point] = (killpiece != null)? killpiece.number.charAt(0): '0';
    return true;
  }

  @Override
  public Point getPosition() {
    now_point.x = parseInt(Info.NOW_X);
    now_point.y = parseInt(Info.NOW_Y);      
    return now_point;
  }
  
  @Override
  public abstract Iterator<Point> movable();
  
  public String toString() {
      return String.valueOf(pieceinfo);  
  }
}
