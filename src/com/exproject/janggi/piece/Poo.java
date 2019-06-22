package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.interfacemod.PieceMove;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Poo implements PieceMove {
    private Board board;
    private Points points = new Points(21);
    private Piece tmp_piece;
    
    public Poo(  ) {
	
    }
    
    /*
     * null = 기록 다른편일땄1�7 = 기록 장군을1�7 아닐땄1�7= 기록
     */
    public Iterator<Point> movable(Board b, Piece poo ){
	this.board = b;
	points.clear();
	Move.point.set(poo.getPosition());
	Move.UP.move();
	while( Move.point.getY() > 0 ){
	    tmp_piece = board.getPiece(Move.point);
	    if( tmp_piece != null ){
		if( !tmp_piece.getClassName().equals(poo.getClassName()) ){
		    Move.UP.move();
		    while( Move.point.getY() > board.MIN_Y && moveChack(poo, Move.point) ){
			Move.UP.move();
		    }
		}
		break;
	    }else{
		Move.UP.move();
	    }
	}
	Move.point.set(poo.getPosition());
	Move.DOWN.move();
	while( Move.point.getY() < board.MAX_Y - 1 ){
	    tmp_piece = board.getPiece(Move.point);
	    if( tmp_piece != null ){
		if( !tmp_piece.getClassName().equals(poo.getClassName()) ){
		    Move.DOWN.move();
		    while( Move.point.getY() < board.MAX_Y && moveChack(poo, Move.point) ){
			Move.DOWN.move();
		    }
		}
		break;
	    }else{
		Move.DOWN.move();
	    }
	}
	Move.point.set(poo.getPosition());
	Move.LEFTE.move();
	while( Move.point.getX() > 0 ){
	    tmp_piece = board.getPiece(Move.point);
	    if( tmp_piece != null ){
		if( !tmp_piece.getClassName().equals(poo.getClassName()) ){
		    Move.LEFTE.move();
		    while( Move.point.getX() >= board.MIN_X && moveChack(poo, Move.point) ){
			Move.LEFTE.move();
		    }
		}
		break;
	    }else{
		Move.LEFTE.move();
	    }
	}
	Move.point.set(poo.getPosition());
	Move.RIGHT.move();
	while( Move.point.getX() < board.MAX_X - 1 ){
	    tmp_piece = board.getPiece(Move.point);
	    if( tmp_piece != null ){
		if( !tmp_piece.getClassName().equals(poo.getClassName()) ){
		    Move.RIGHT.move();
		    while( Move.point.getX() < board.MAX_X && moveChack(poo, Move.point) ){
			Move.RIGHT.move();
		    }
		}
		break;
	    }else{
		Move.RIGHT.move();
	    }
	}
	if( poo.getPosition().equals(board.castleup[0]) || poo.getPosition().equals(board.castledown[0]) ){
	    Move.point.set(poo.getPosition());
	    Move.RIGHTDOWN.move();
	    tmp_piece =board.getPiece(Move.point); 
	    if( tmp_piece != null && !tmp_piece.getClassName().equals(poo.getClassName()) ){
		Move.RIGHTDOWN.move();
		moveChack(poo, Move.point);
	    }
	}else if( poo.getPosition().equals(board.castleup[2]) || poo.getPosition().equals(board.castledown[2]) ){
	    Move.point.set(poo.getPosition());
	    Move.LEFTEDOWN.move();
	    tmp_piece =board.getPiece(Move.point);
	    if( tmp_piece != null && !tmp_piece.getClassName().equals(poo.getClassName()) ){
		Move.LEFTEDOWN.move();
		moveChack(poo, Move.point);
	    }
	}else if( poo.getPosition().equals(board.castleup[6]) || poo.getPosition().equals(board.castledown[6]) ){
	    Move.point.set(poo.getPosition());
	    Move.RIGHTUP.move();
	    tmp_piece =board.getPiece(Move.point);
	    if( tmp_piece != null && !tmp_piece.getClassName().equals(poo.getClassName()) ){
		Move.RIGHTUP.move();
		moveChack(poo, Move.point);
	    }
	}else if( poo.getPosition().equals(board.castleup[8]) || poo.getPosition().equals(board.castledown[8]) ){
	    Move.point.set(poo.getPosition());
	    Move.LEFTEUP.move();
	    tmp_piece =board.getPiece(Move.point);
	    if( tmp_piece != null && !tmp_piece.getClassName().equals(poo.getClassName()) ){
		Move.LEFTEUP.move();
		moveChack(poo, Move.point);
	    }
	}
	return points.getMovable();
    }
    
    private boolean moveChack( Piece poo, Point p ){
	tmp_piece = board.getPiece(p);
	if( tmp_piece == null ){
	    points.add(p);
	    return true;
	}
	if( poo.isTeam(tmp_piece) && !tmp_piece.getClassName().equals(poo.getClassName()) ){
	    points.add(p);
	}
	return false;
    }
}