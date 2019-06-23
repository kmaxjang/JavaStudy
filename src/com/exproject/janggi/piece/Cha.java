package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.interfacemod.PieceMove;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Cha implements PieceMove {
    
    private Board board;
    private Points points = new Points(21);
    private Piece tmp_piece;
    
    public Cha() {	
    }
    
    /*
     * null = 기록 다른편일땄1�71ￄ1�77 = 기록 장군을1�71ￄ1�77 아닐땄1�71ￄ1�77= 기록
     */
    public Iterator<Point> movable(Board b, Piece cha ){
	this.board = b;
	points.clear();
	Move.point.set(cha.getPosition());
	Move.UP.move();
	while( Move.UP.scope() && moveChack(cha, Move.point) ){
	    Move.UP.move();
	}
	Move.point.set(cha.getPosition());
	Move.DOWN.move();
	while( Move.DOWN.scope() && moveChack(cha, Move.point) ){
	    Move.DOWN.move();
	}
	Move.point.set(cha.getPosition());
	Move.LEFTE.move();
	while( Move.LEFTE.scope() && moveChack(cha, Move.point) ){
	    Move.LEFTE.move();
	}
	Move.point.set(cha.getPosition());
	Move.RIGHT.move();
	while( Move.RIGHT.scope() && moveChack(cha, Move.point) ){
	    Move.RIGHT.move();
	}
	
	if( cha.getPosition().equals(board.castleup[0]) || cha.getPosition().equals(board.castledown[0]) ){
	    Move.point.set(cha.getPosition());
	    Move.RIGHT.move();
	    if( moveChack(cha, Move.point) ){
		Move.RIGHT.move();
		moveChack(cha, Move.point);
	    }
	}else if( cha.getPosition().equals(board.castleup[2]) || cha.getPosition().equals(board.castledown[2]) ){
	    Move.point.set(cha.getPosition());
	    Move.LEFTE.move();
	    if( moveChack(cha, Move.point) ){
		Move.LEFTE.move();
		moveChack(cha, Move.point);
	    }
	}else if( cha.getPosition().equals(board.castleup[4]) || cha.getPosition().equals(board.castledown[4]) ){
	    Move.point.set(cha.getPosition());
	    Move.LEFTEUP.move();
	    moveChack(cha, Move.point);
	    Move.point.set(cha.getPosition());
	    Move.RIGHTUP.move();
	    moveChack(cha, Move.point);
	    Move.point.set(cha.getPosition());
	    Move.LEFTEDOWN.move();
	    moveChack(cha, Move.point);
	    Move.point.set(cha.getPosition());
	    Move.RIGHTDOWN.move();
	    moveChack(cha, Move.point);
	}else if( cha.getPosition().equals(board.castleup[6]) || cha.getPosition().equals(board.castledown[6]) ){
	    Move.point.set(cha.getPosition());
	    Move.RIGHTUP.move();
	    if( moveChack(cha, Move.point) ){
		Move.RIGHTUP.move();
		moveChack(cha, Move.point);
	    }
	}else if( cha.getPosition().equals(board.castleup[8]) || cha.getPosition().equals(board.castledown[8]) ){
	    Move.point.set(cha.getPosition());
	    Move.LEFTEUP.move();
	    if( moveChack(cha, Move.point) ){
		Move.LEFTEUP.move();
		moveChack(cha, Move.point);
	    }
	}
	return points.getMovable();
    }
    
    private boolean moveChack( Piece cha, Point p ){
	tmp_piece = board.getPiece(p);
	if( tmp_piece == null ){
	    points.add(p);
	    return true;
	}
	if(!cha.isTeam(tmp_piece)){
	    points.add(p);
	}
	return false;
    }
}
