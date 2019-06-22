package com.exproject.janggi.piece;

import java.util.Iterator;
import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.interfacemod.PieceMove;
import com.exproject.janggi.interfacemod.Piece.Team;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class King implements PieceMove {
    
    private Board board;
    private Points points = new Points(8);
    private Point[] castle;
    private Piece tmp_piece;
    
    public King( ) {
	
    }
    
    /*
     * null = 기록 다른편일땄1�7 = 기록 장군을1�7 아닐땄1�7= 기록
     */
    public Iterator<Point> movable( Board b, Piece king ){
	this.board = b;
	castle = (king.getTeamName() == Team.HAN) ? board.castleup : board.castledown;
	points.clear();
	if( king.getPosition().equals(castle[0]) ){
	    Move.point.set(king.getPosition());
	    Move.RIGHT.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.DOWN.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.RIGHTDOWN.move();
	    moveChack(king, Move.point);
	}else if( king.getPosition().equals(castle[1]) ){
	    Move.point.set(king.getPosition());
	    Move.LEFTE.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.RIGHT.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.DOWN.move();
	    moveChack(king, Move.point);
	}else if( king.getPosition().equals(castle[2]) ){
	    Move.point.set(king.getPosition());
	    Move.LEFTE.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.LEFTEDOWN.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.DOWN.move();
	    moveChack(king, Move.point);
	}else if( king.getPosition().equals(castle[3]) ){
	    Move.point.set(king.getPosition());
	    Move.UP.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.RIGHT.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.DOWN.move();
	    moveChack(king, Move.point);
	}else if( king.getPosition().equals(castle[4]) ){
	    Move.point.set(king.getPosition());
	    Move.LEFTEUP.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.UP.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.RIGHTUP.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.LEFTE.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.RIGHT.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.LEFTEDOWN.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.DOWN.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.RIGHTDOWN.move();
	    moveChack(king, Move.point);
	}else if( king.getPosition().equals(castle[5]) ){
	    Move.point.set(king.getPosition());
	    Move.UP.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.LEFTE.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.DOWN.move();
	    moveChack(king, Move.point);
	}else if( king.getPosition().equals(castle[6]) ){
	    Move.point.set(king.getPosition());
	    Move.UP.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.RIGHTUP.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.RIGHT.move();
	    moveChack(king, Move.point);
	}else if( king.getPosition().equals(castle[7]) ){
	    Move.point.set(king.getPosition());
	    Move.UP.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.LEFTE.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.RIGHT.move();
	    moveChack(king, Move.point);
	}else if( king.getPosition().equals(castle[8]) ){
	    Move.point.set(king.getPosition());
	    Move.LEFTEUP.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.UP.move();
	    moveChack(king, Move.point);
	    Move.point.set(king.getPosition());
	    Move.LEFTE.move();
	    moveChack(king, Move.point);
	}
	return points.getMovable();
    }
    
    private boolean moveChack( Piece king, Point p ){
	tmp_piece = board.getPiece(p);
	if( tmp_piece == null ){
	    points.add(p);
	    return true;
	}
	if( king.isTeam( tmp_piece) ){
	    points.add(p);
	}
	return false;
    }
}
