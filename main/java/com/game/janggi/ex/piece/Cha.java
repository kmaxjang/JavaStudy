package com.game.janggi.ex.piece;

import java.util.Iterator;

import com.game.janggi.ex.ex1.Board;
import com.game.janggi.ex.interfacemod.Piece;
import com.game.janggi.ex.interfacemod.PieceMove;
import com.game.janggi.ex.util.Move;
import com.game.janggi.ex.util.Point;
import com.game.janggi.ex.util.Points;

public class Cha implements PieceMove {

  private Board board;
  private Points points = new Points(21);
  private Piece tmp_piece;

  public Cha() {}

  /*
   * 
   */
  public Iterator<Point> moveable(Board b) {
    this.board = b;
    points.clear();
    
    final Point sp = cha.position();
    for(int loop = 0; loop <loop.length ; loop++) {
      Point tmp = sp;
      Move move= Move.loop[loop];
      while (move.scope(tmp) && moveChack(cha, move.go(tmp))) {
        tmp = move.go(tmp);
      }
    }
    
    if (sp.equals(board.castleup[0]) || sp.equals(board.castledown[0])) {      
      if (moveChack(cha, tmp = Move.RIGHT.go(sp))) {        
        moveChack(cha, MoveRIGHT.go(tmp);
      }
    } else if (sp.equals(board.castleup[1]) || sp.equals(board.castledown[1])) {
      if (moveChack(cha, tmp = Move.LEFT.go(sp))) {        
        moveChack(cha, MoveLEFT.go(tmp);
      }
    } else if (sp.equals(board.castleup[2]) || sp.equals(board.castledown[2])) {
      if (moveChack(cha, tmp = Move.RIGHTUP.go(sp))) {        
        moveChack(cha, RIGHTUP.go(tmp);
      }
    } else if (sp.equals(board.castleup[3]) || sp.equals(board.castledown[3])) {
      if (moveChack(cha, tmp = Move.LEFTUP.go(sp))) {        
        moveChack(cha, MoveLEFTUP.go(tmp);
      }
    } else if (sp.equals(board.castleup[4]) || sp.equals(board.castledown[4])) {
        moveChack(cha, Move.RIGHTUP.go(sp));
        moveChack(cha, Move.RIGHTDOWN.go(sp));
        moveChack(cha, Move.LEFTDOWN.go(sp));
        moveChack(cha, Move.LEFTUP.go(sp));
    } 
    return points.getMovable();
  }

  private boolean moveChack(Piece cha, Point p) {
    tmp_piece = board.getPiece(p);
    if (tmp_piece == null) {
      // 빈공간
      points.add(p);
      return true;
    }
    if (cha.isTeam(tmp_piece)) {
      // 잡을수있는말
      points.add(p);
    }
    return false;
  }
}
