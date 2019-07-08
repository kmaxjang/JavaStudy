package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.interfacemod.PieceMove;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Jol implements PieceMove {
    
    private Piece jol;
    private Board board;
    private Points points = new Points(5);
    private Piece tmp_piece;    
    
    public Jol(Board board) {
	this.board = board;
    }
    
    public Iterator<Point> movable(Piece jol ){
	this.jol = jol;
		
	
	points.clear();
	
	Move.point.set(jol.getPosition());
	Move.LEFTE.move();
	if( Move.LEFTE.scope()) { 
	    moveChack(Move.point);
	}
	Move.point.set(jol.getPosition());
	Move.RIGHT.move();
	if( Move.RIGHT.scope()) {
	    moveChack(Move.point);
	}
	
	if( jol.getTeam() == Piece.Team.HAN ){
	    Move.point.set(jol.getPosition());
	    Move.DOWN.move();
	    if( Move.DOWN.scope()) {
		moveChack(Move.point);
	    }
	    Move.point.set(jol.getPosition());
	    if(Move.point.equals(board.castledown[0]) ){		
		Move.RIGHTDOWN.move();
		moveChack(Move.point);
	    }else if(Move.point.equals(board.castledown[2]) ){		
		Move.LEFTEDOWN.move();
		moveChack(Move.point);
	    }else if(Move.point.equals(board.castledown[4]) ){		
		Move.LEFTEDOWN.move();
		moveChack(Move.point);
		Move.RIGHT.move();
		moveChack(Move.point);
		Move.RIGHT.move();
		moveChack(Move.point);
	    }
	}else{
	    Move.point.set(jol.getPosition());
	    Move.UP.move();
	    if( Move.UP.scope()) {
		moveChack(Move.point);
	    }	    
	    Move.point.set(jol.getPosition());
	    if(Move.point.equals(board.castleup[6]) ){		
		Move.RIGHTUP.move();
		moveChack(Move.point);
	    }else if(Move.point.equals(board.castleup[8]) ){		
		Move.LEFTEUP.move();
		moveChack(Move.point);
	    }else if(Move.point.equals(board.castleup[4]) ){		
		Move.LEFTEUP.move();
		moveChack(Move.point);
		Move.RIGHT.move();
		moveChack(Move.point);
		Move.RIGHT.move();
		moveChack(Move.point);
	    }
	}
	return points.getMovable();
    }
    
    private boolean moveChack(Point p ){
	tmp_piece = board.getPiece(p);
	if( tmp_piece == null ){
	    points.add(p);
	    return true;
	}
	if( jol.equalsTeam(tmp_piece) ){
	    points.add(p);
	}
	return false;
    }
}
