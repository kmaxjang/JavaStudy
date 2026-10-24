package com.exproject.pattern.thread;

import com.game.janggi.ex.util.Point;

public interface PlayCommand {

	public boolean pieceMove(Piece piece, Point p);
	
	public Piece getPiece(Point p);
}
