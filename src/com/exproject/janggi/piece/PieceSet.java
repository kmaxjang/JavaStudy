package com.exproject.janggi.piece;

import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.util.Point;

// 장기말 기본정의 Piece인터페이스 구현
public class PieceSet implements Piece {

  private char[] pieceinfo;
  private Point now_point = new Point(0, 0);

  public PieceSet(int piece) {
    this(String.valueOf(piece));
    System.out.println("숫자"+piece);
  }

  public PieceSet(String piece) {
    pieceinfo = piece.toCharArray();
    System.out.println("문자"+getTeamName()+" "+getClassName()+"좌표"+getPosition().x+" "+getPosition().y);
  }

  @Override
  public boolean isTeam(Piece piece) {
    return (pieceinfo[Info.TEAM.POINT] == piece.parse(Info.TEAM).charAt(0));
  }

  @Override
  public Team getTeamName() {
    switch (pieceinfo[Info.TEAM.POINT]) {
      case '1':
        return Team.CHO;
      case '2':
        return Team.HAN;
    }
    return null;
  }

  @Override
  public ClassName getClassName() {
    switch (pieceinfo[Info.CLASS.POINT]) {
      case '7':
        return ClassName.CHA;
      case '6':
        return ClassName.POO;
      case '5':
        return ClassName.MA;
      case '4':
        return ClassName.SAG;
      case '3':
        return ClassName.SA;
      case '2':
        return ClassName.JOL;
      case '1':
        return ClassName.KING;
    }
    return null;
  }

  @Override
  public String info() {
    return String.valueOf(pieceinfo);
  }

  @Override
  public int infoCommand() {
    return Integer.valueOf(info());
  }

  @Override
  public int parseInt(Info p) {
    return Integer.valueOf(parse(p));
  }

  @Override
  public String parse(Info p) {
    return String.valueOf(pieceinfo[p.POINT]);
  }

  @Override
  public boolean move(Point p, Piece killpiece) {
    pieceinfo[Info.OLD_X.POINT] = pieceinfo[Info.NOW_X.POINT];
    pieceinfo[Info.OLD_Y.POINT] = pieceinfo[Info.NOW_Y.POINT];
    pieceinfo[Info.NOW_X.POINT] = (char)(p.x+0x30);
    pieceinfo[Info.NOW_Y.POINT] = (char)(p.y+0x30);

    pieceinfo[Info.KILL_CLASS.POINT] = (killpiece != null) ?killpiece.getClassName().NUMBER.charAt(0) : '0';
    return true;
  }

  @Override
  public Point getPosition() {
      now_point.x = parseInt(Info.NOW_X);
      now_point.y = parseInt(Info.NOW_Y);
    return now_point;
  }
}
