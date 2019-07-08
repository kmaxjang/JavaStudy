package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.interfacemod.PieceMove;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Ma implements PieceMove {
    private Piece ma; 
    private Board board;
    private Points points = new Points(8);
    private Piece tmp_piece;
    private Point tmp_point = new Point();
    
    public Ma(Board board) {
	this.board = board;
    }
    
    public void maWay( Move m){
	m.move();
	if( m.scope() ){
	    moveChack(Move.point);
	}
    }
    
    /*
     * null = 기록 다른편일땄1�7 = 기록 장군을1�7 아닐땄1�7= 기록
     */
    public Iterator<Point> movable(Piece ma ){
	this.ma = ma;	
	points.clear();
	
	Move.point.set(ma.getPosition());
	Move.UP.move();
	if( Move.UP.scope() && board.getPiece(Move.point) == null ){
	    tmp_point.set(Move.point);
	    maWay(Move.LEFTEUP);
	    Move.point.set(tmp_point);
	    maWay(Move.RIGHTUP);
	}
	Move.point.set(ma.getPosition());
	Move.DOWN.move();
	if( Move.DOWN.scope() && board.getPiece(Move.point) == null ){
	    tmp_point.set(Move.point);
	    maWay(Move.LEFTEDOWN);
	    Move.point.set(tmp_point);
	    maWay(Move.RIGHTDOWN);
	}
	Move.point.set(ma.getPosition());
	Move.LEFTE.move();
	if( Move.LEFTE.scope() && board.getPiece(Move.point) == null ){
	    tmp_point.set(Move.point);
	    maWay(Move.LEFTEUP);
	    Move.point.set(tmp_point);
	    maWay(Move.LEFTEDOWN);
	}
	
	Move.point.set(ma.getPosition());
	Move.RIGHT.move();
	if( Move.RIGHT.scope() && board.getPiece(Move.point) == null ){
	    tmp_point.set(Move.point);
	    maWay(Move.RIGHTUP);
	    Move.point.set(tmp_point);
	    maWay(Move.RIGHTDOWN);
	}
	return points.getMovable();
    }
    
    private boolean moveChack(Point p ){
	tmp_piece = board.getPiece(p);
	if( tmp_piece == null ){
	    points.add(p);
	    return true;
	}
	if( !ma.equalsTeam(tmp_piece) ){
	    points.add(p);
	}
	return false;
    }
}
