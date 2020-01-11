package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Poo extends PieceSet{
    private Piece poo;
    private Board board;
    private Points points = new Points(14);
    private Piece tmp_piece;
    
    public Poo( Board board, int piece ) {
	super(piece);
	this.board = board;
    }
    
    public Iterator<Point> movable(){
	points.clear();
	
	Move.point.set(getPosition());
	pooWay(Move.UP);
	
	Move.point.set(getPosition());
	pooWay(Move.DOWN);
	
	Move.point.set(getPosition());
	pooWay(Move.LEFTE);
	
	Move.point.set(getPosition());
	pooWay(Move.RIGHT);
	
	Move.point.set(getPosition());
	if(Move.point.equals(board.castleup[0]) || Move.point.equals(board.castledown[0])){
	    castleWay(Move.RIGHTDOWN);
	}else if(Move.point.equals(board.castleup[2]) || Move.point.equals(board.castledown[2])){
	    castleWay(Move.LEFTEDOWN);
	}else if(Move.point.equals(board.castleup[6]) || Move.point.equals(board.castledown[6])){
	    castleWay(Move.RIGHTUP);
	}else if(Move.point.equals(board.castleup[8]) || Move.point.equals(board.castledown[8])){
	    castleWay(Move.LEFTEUP);
	}
	return points.getMovable();
    }
    
    private void castleWay( Move m ){
	m.move();
	tmp_piece = board.getPiece(Move.point);
	if(tmp_piece != null && !tmp_piece.getClassName().equals(Piece.ClassName.POO)){
	    m.move();
	    moveChack(Move.point);
	}
    }
    
    private void pooWay( Move m ){
	m.move();
	while(m.scope()){
	    tmp_piece = board.getPiece(Move.point);
	    if(tmp_piece != null){
		if(!tmp_piece.getClassName().equals(Piece.ClassName.POO)){
		    m.move();
		    while(m.scope() && moveChack(Move.point)){
			m.move();
		    }
		}
		break;
	    }else{
		m.move();
	    }
	}
    }
    
    private boolean moveChack( Point p ){
	tmp_piece = board.getPiece(p);
	if(tmp_piece == null){
	    points.add(p);
	    return true;
	}
	if(!tmp_piece.getClassName().equals(Piece.ClassName.POO) && !tmp_piece.equalsTeam(poo)){
	    points.add(p);
	}
	return false;
    }
}
