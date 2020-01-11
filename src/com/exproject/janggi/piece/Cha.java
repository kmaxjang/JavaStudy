package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Cha extends PieceSet{
    private Board board;
    private Points points = new Points(21);
    private Piece tmp_piece;
    
    public Cha( Board board, int piece ) {
	super(piece);
	this.board = board;
    }
    
    public Iterator<Point> movable(){
	points.clear();
	
	Move.point.set(getPosition());
	Move.UP.move();
	while(Move.UP.scope() && moveChack(Move.point)){
	    Move.UP.move();
	}
	Move.point.set(getPosition());
	Move.DOWN.move();
	while(Move.DOWN.scope() && moveChack(Move.point)){
	    Move.DOWN.move();
	}
	Move.point.set(getPosition());
	Move.LEFTE.move();
	while(Move.LEFTE.scope() && moveChack(Move.point)){
	    Move.LEFTE.move();
	}
	Move.point.set(getPosition());
	Move.RIGHT.move();
	while(Move.RIGHT.scope() && moveChack(Move.point)){
	    Move.RIGHT.move();
	}
	
	if(getPosition().equals(board.castleup[0]) || getPosition().equals(board.castledown[0])){
	    Move.point.set(getPosition());
	    Move.RIGHTDOWN.move();
	    if(moveChack(Move.point)){
		Move.RIGHTDOWN.move();
		moveChack(Move.point);
	    }
	}else if(getPosition().equals(board.castleup[2]) || getPosition().equals(board.castledown[2])){
	    Move.point.set(getPosition());
	    Move.LEFTEDOWN.move();
	    if(moveChack(Move.point)){
		Move.LEFTEDOWN.move();
		moveChack(Move.point);
	    }
	}else if(getPosition().equals(board.castleup[4]) || getPosition().equals(board.castledown[4])){
	    Move.point.set(getPosition());
	    Move.LEFTEUP.move();
	    moveChack(Move.point);
	    Move.point.set(getPosition());
	    Move.RIGHTUP.move();
	    moveChack(Move.point);
	    Move.point.set(getPosition());
	    Move.LEFTEDOWN.move();
	    moveChack(Move.point);
	    Move.point.set(getPosition());
	    Move.RIGHTDOWN.move();
	    moveChack(Move.point);
	}else if(getPosition().equals(board.castleup[6]) || getPosition().equals(board.castledown[6])){
	    Move.point.set(getPosition());
	    Move.RIGHTUP.move();
	    if(moveChack(Move.point)){
		Move.RIGHTUP.move();
		moveChack(Move.point);
	    }
	}else if(getPosition().equals(board.castleup[8]) || getPosition().equals(board.castledown[8])){
	    Move.point.set(getPosition());
	    Move.LEFTEUP.move();
	    if(moveChack(Move.point)){
		Move.LEFTEUP.move();
		moveChack(Move.point);
	    }
	}
	return points.getMovable();
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
