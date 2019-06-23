package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.interfacemod.PieceMove;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Ma implements PieceMove {
    private Board board;
    private Points points = new Points(8);
    private Piece tmp_piece;
    private Point tmp_point = new Point();
    
    public Ma() {
    }
    
    public void maWay( Move m, Piece sag ){
	m.move();
	if( m.scope() ){
	    moveChack(sag, Move.point);
	}
    }
    
    /*
     * null = 기록 다른편일땄1�7 = 기록 장군을1�7 아닐땄1�7= 기록
     */
    public Iterator<Point> movable( Board b, Piece ma ){
	this.board = b;
	points.clear();
	Move.point.set(ma.getPosition());
	Move.UP.move();
	if( Move.UP.scope() && board.getPiece(Move.point) == null ){
	    tmp_point = Move.point;
	    maWay(Move.LEFTEUP, ma);
	    Move.point.set(tmp_point);
	    maWay(Move.RIGHTUP, ma);
	}
	Move.point.set(ma.getPosition());
	Move.DOWN.move();
	if( Move.DOWN.scope() && board.getPiece(Move.point) == null ){
	    tmp_point = Move.point;
	    maWay(Move.LEFTEDOWN, ma);
	    Move.point.set(tmp_point);
	    maWay(Move.RIGHTDOWN, ma);
	}
	Move.point.set(ma.getPosition());
	Move.LEFTE.move();
	if( Move.LEFTE.scope() && board.getPiece(Move.point) == null ){
	    tmp_point = Move.point;
	    maWay(Move.LEFTEUP, ma);
	    Move.point.set(tmp_point);
	    maWay(Move.LEFTEDOWN, ma);
	}
	
	Move.point.set(ma.getPosition());
	Move.RIGHT.move();
	if( Move.RIGHT.scope() && board.getPiece(Move.point) == null ){
	    tmp_point = Move.point;
	    maWay(Move.RIGHTUP, ma);
	    Move.point.set(tmp_point);
	    maWay(Move.RIGHTDOWN, ma);
	}
	return points.getMovable();
    }
    
    private boolean moveChack( Piece ma, Point p ){
	tmp_piece = board.getPiece(p);
	if( tmp_piece == null ){
	    points.add(p);
	    return true;
	}
	if( ma.isTeam(tmp_piece) ){
	    points.add(p);
	}
	return false;
    }
}
