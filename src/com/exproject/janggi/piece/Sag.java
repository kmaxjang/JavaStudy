package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.interfacemod.PieceMove;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Sag implements PieceMove {
    
    private Board board;
    private Points points = new Points(8);
    private Piece tmp_piece;
    private Point tmp_point = new Point();
    
    public Sag() {
	
    }
    
    public void sagWay( Move m, Piece sag ){
	m.move();
	if( m.scope() && board.getPiece(Move.point) == null ){
	    m.move();
	    if( m.scope() ){
		moveChack(sag, Move.point);
	    }
	}
    }
    
    /*
     * null = 기록 다른편일땄1�7 = 기록 장군을1�7 아닐땄1�7= 기록
     */
    public Iterator<Point> movable( Board b, Piece sag ){
	this.board = b;
	points.clear();
	Move.point.set(sag.getPosition());
	Move.UP.move();
	if( Move.UP.scope() && board.getPiece(Move.point) == null ){
	    tmp_point = Move.point;
	    sagWay(Move.LEFTEUP, sag);
	    Move.point.set(tmp_point);
	    sagWay(Move.RIGHTUP, sag);
	}
	Move.point.set(sag.getPosition());
	Move.DOWN.move();
	if( Move.DOWN.scope() && board.getPiece(Move.point) == null ){
	    tmp_point = Move.point;
	    sagWay(Move.LEFTEDOWN, sag);
	    Move.point.set(tmp_point);
	    sagWay(Move.RIGHTDOWN, sag);
	}
	Move.point.set(sag.getPosition());
	Move.LEFTE.move();
	if( Move.LEFTE.scope() && board.getPiece(Move.point) == null ){
	    tmp_point = Move.point;
	    sagWay(Move.LEFTEUP, sag);
	    Move.point.set(tmp_point);
	    sagWay(Move.LEFTEDOWN, sag);
	}
	
	Move.point.set(sag.getPosition());
	Move.RIGHT.move();
	if( Move.RIGHT.scope() && board.getPiece(Move.point) == null ){
	    tmp_point = Move.point;
	    sagWay(Move.RIGHTUP, sag);
	    Move.point.set(tmp_point);
	    sagWay(Move.RIGHTDOWN, sag);
	}
	return points.getMovable();
    }
    
    private boolean moveChack( Piece sag, Point p ){
	tmp_piece = board.getPiece(p);
	if( tmp_piece == null ){
	    points.add(p);
	    return true;
	}
	if( sag.isTeam(tmp_piece) ){
	    points.add(p);
	}
	return false;
    }
}
