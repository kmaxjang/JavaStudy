package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Sag extends PieceSet{
    
    private Board board;
    private Points points = new Points(8);
    private Piece tmp_piece;
    private Point tmp_point = new Point();
    
    public Sag( Board board, int piece ) {
	super(piece);
	this.board = board;
    }
    
    public Iterator<Point> movable(){
	points.clear();
	
	Move.point.set(getPosition());
	Move.UP.move();
	if(Move.UP.scope() && board.getPiece(Move.point) == null){
	    tmp_point.set(Move.point);
	    sagWay(Move.LEFTEUP);
	    Move.point.set(tmp_point);
	    sagWay(Move.RIGHTUP);
	}
	Move.point.set(getPosition());
	Move.DOWN.move();
	if(Move.DOWN.scope() && board.getPiece(Move.point) == null){
	    tmp_point.set(Move.point);
	    sagWay(Move.LEFTEDOWN);
	    Move.point.set(tmp_point);
	    System.out.println("x" + Move.point.x + " y" + Move.point.y);
	    sagWay(Move.RIGHTDOWN);
	}
	Move.point.set(getPosition());
	Move.LEFTE.move();
	if(Move.LEFTE.scope() && board.getPiece(Move.point) == null){
	    tmp_point.set(Move.point);
	    sagWay(Move.LEFTEUP);
	    Move.point.set(tmp_point);
	    sagWay(Move.LEFTEDOWN);
	}
	
	Move.point.set(getPosition());
	Move.RIGHT.move();
	if(Move.RIGHT.scope() && board.getPiece(Move.point) == null){
	    tmp_point.set(Move.point);
	    sagWay(Move.RIGHTUP);
	    Move.point.set(tmp_point);
	    sagWay(Move.RIGHTDOWN);
	}
	return points.getMovable();
    }
    
    private void sagWay( Move m ){
	m.move();
	if(m.scope() && board.getPiece(Move.point) == null){
	    m.move();
	    if(m.scope()){
		moveChack(Move.point);
	    }
	}
    }
    
    private boolean moveChack( Point p ){
	tmp_piece = board.getPiece(p);
	if(tmp_piece == null){
	    points.add(p);
	    return true;
	}
	if(!equalsTeam(tmp_piece)){
	    points.add(p);
	}
	return false;
    }
}
