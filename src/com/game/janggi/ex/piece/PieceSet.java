package com.game.janggi.ex.piece;

import com.game.janggi.ex.interfacemod.Piece;
import com.game.janggi.ex.util.Point;

// 장기말 기본정의 Piece인터페이스 구현
public class PieceSet implements Piece {

  private final int[] pieceinfo;
  private Point now_point = new Point(0, 0);

  public PieceSet(int piece) {
      int[] tmp2 = new int[7];
      int count = 1000000;
    for(int a =0; a < tmp2.length; a++) {
	System.out.println("숫자"+piece);
	tmp2[a] = piece / count;
	piece = piece % count;
	count = count/10;	
    }
    pieceinfo = tmp2;    
    System.out.println("문자"+getTeam()+" "+getPieceName()+" 좌표"+getPosition());
  }

  public PieceSet(String piece) {
    char[] tmp = piece.toCharArray();
    int[] tmp2 = new int[tmp.length];
    for(int a =0; a < tmp.length; a++) {
	tmp2[a] = tmp[a]- 0x30;
    }
    pieceinfo = tmp2;
    System.out.println("문자"+getTeam()+" "+getPieceName()+"좌표"+getPosition());
  }

  @Override
  public boolean isTeam(Piece piece) {
    return false;
  }

  @Override
  public Team getTeam() {
    return Team.get(parseInt(PieceCode.TEAM));
  }

  @Override
  public PieceName getPieceName() {    
    return PieceName.get(parseInt(PieceCode.PIECE_NAME));
  }

  @Override
  public Piece info() {
    return Piece.valueOf(pieceinfo);
  }

  @Override
  public int infoCommand() {
    return Integer.valueOf(info());
  }

  @Override
  public int parseInt(PieceCode p) {
    return pieceinfo[p.get()];
  }

  @Override
  public Piece parse(PieceCode p) {
    return Piece.valueOf(pieceinfo[p.get()]);
  }

  @Override
  public boolean move(Point p, Piece killpiece) {
    pieceinfo[PieceCode.OLD_X.get()] = pieceinfo[PieceCode._X.get()];
    pieceinfo[PieceCode.OLD_Y.get()] = pieceinfo[PieceCode._Y.get()];
    pieceinfo[PieceCode._X.get()] = p.getX();
    pieceinfo[PieceCode._Y.get()] = p.getY();
    pieceinfo[PieceCode.KILL_PIECE.get()] = (killpiece != null) ?killpiece.getPieceName().CODE : '0';
    return true;
  }

  @Override
  public Point getPosition() {
      now_point.setX(parseInt(PieceCode._X));
      now_point.setY(parseInt(PieceCode._Y));
    return now_point;
  }

@Override
public Point getOldPosition() {
    // TODO Auto-generated method stub
    return null;
}

@Override
public PieceName getKillName() {
    // TODO Auto-generated method stub
    return null;
}

}
