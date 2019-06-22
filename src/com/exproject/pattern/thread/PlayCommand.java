package com.exproject.pattern.thread;

import com.exproject.janggi.util.Point;

public interface PlayCommand {

	public boolean pieceMove(Piece piece, Point p);
	
	public Piece getPiece(Point p);
}
