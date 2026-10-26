package com.game.janggi.ex.piece;

import java.util.Iterator;

import com.game.janggi.ex.Board;
import com.game.janggi.ex.interfacemod.Piece;
import com.game.janggi.ex.interfacemod.PieceMove;
import com.game.janggi.ex.util.Move;
import com.game.janggi.ex.util.Point;
import com.game.janggi.ex.util.Points;

public class Poo implements PieceMove {
	private Board board;
	private Points points = new Points(21);
	private Piece tmp_piece;

	public Poo() {

	}

	/*
	 * null = 기록 다른편일땄1�7 = 기록 장군을1�7 아닐땄1�7= 기록
	 */
	public Iterator<Point> moveable(Board b) {
		this.board = b;
		points.clear();
		
		final Point sp = poo.position();
		for(int loop = 0; loop <loop.length; loop++) {
		  Point tmp = sp;
		  Move move = Move.loop[loop];
		  while (move.scope(tmp)) {
		    tmp = move.go(tmp);		    
            tmp_piece = board.getPiece(tmp);
            if (tmp_piece != null && tmp_piece.types() != Piece.Types.POO) {
              while(move.scope(tmp) && moveChack(poo, tmp = move.go(tmp))){                
              }
               break;
            }
           }
		  }
		
		if (sp.equals(board.castleup[0]) || sp.equals(board.castledown[0])) {			
			tmp_piece = board.getPiece(tmp=Move.RIGHTDOWN.go(sp));
			if (tmp_piece != null && tmp_piece.types()!= PieceTypes.POO)) {				
				moveChack(poo, Move.RIGHTDOWN.go(tmp));
			}
		} else if (sp.equals(board.castleup[1]) || sp.equals(board.castledown[1])) {
		  tmp_piece = board.getPiece(tmp=Move.LEFTDOWN.go(sp));
          if (tmp_piece != null && tmp_piece.types()!= PieceTypes.POO)) {             
              moveChack(poo, Move.LEFTDOWN.go(tmp));
          }
		} else if (sp.equals(board.castleup[2]) || sp.equals(board.castledown[2])) {
		  tmp_piece = board.getPiece(tmp=Move.RIGHTUP.go(sp));
          if (tmp_piece != null && tmp_piece.types()!= PieceTypes.POO)) {             
              moveChack(poo, Move.RIGHTUP.go(tmp));
          }
		} else if (sp.equals(board.castleup[3]) || sp.equals(board.castledown[3])) {
		  tmp_piece = board.getPiece(tmp=Move.RIGHTUP.go(sp));
          if (tmp_piece != null && tmp_piece.types()!= PieceTypes.POO)) {             
              moveChack(poo, Move.RIGHTUP.go(tmp));
          }
		}
		return points.getMovable();
	}

	private boolean moveChack(Piece poo, Point p) {
		tmp_piece = board.getPiece(p);
		if (tmp_piece == null) {
		  //빈공간
			points.add(p);
			return true;
		}
		if (!poo.isGroup(tmp_piece) && tmp_piece.types() != Piece.Types.POO)) {
			points.add(p);
		}
		return false;
	}
}