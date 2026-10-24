package com.ex01;

import com.ex01.PieceType;
import com.ex01.Point;
import com.ex01.Piece;

public class Log {

  public final int piece;
  public final int nowpoint;
  public final int oldpoint;
  public final int takepiece;
  
  public final int code;

  private Log(Piece piece, Point nowpoint, Point oldpoint, PieceType takepiece) {
    this.piece = piece.code();
    this.nowpoint = nowpoint.code();
    this.oldpoint = oldpoint.code();
    this.takepiece = (takepiece != null)? takepiece.code():0;
    code = decode();
  }
    
  public static Log create(Piece piece, Point nowpoint, Point oldpoint, PieceType takepiece){
    if(piece == null || nowpoint == null || oldpoint == null){
      return null;
    }
    return new Log(piece, nowpoint, oldpoint, takepiece);
  }
  
  public static Log builder(int code){
    return null;
  }
  
  private int decode(){
    int code = 0;
    code = piece*10_000;
    code += nowpoint*1000;
    code += oldpoint*10;
    code += takepiece;
    return code;
  }
  
  public int code(){
    return code;
  }
  
}
