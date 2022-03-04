package com.exproject.janggi.util;

import com.exproject.janggi.Board;
import com.exproject.janggi.piece.Piece;

public class Checkmate {

	private Board board;
	private Piece king;
	private Points points = new Points(30);
	private Piece tmp_piece;

	private Move[] way = Move.values();

	private Point[] sagpoint = {
	    new Point(2, -3),
	    new Point(3, -2),
	    new Point(3, 2),
	    new Point(2, 3),
	    new Point(-2, 3),
	    new Point(-3, 2),
	    new Point(-3, -2),
	    new Point(-2, -3)
	};

	private boolean checkChaPoo() {
		for (int w = 0; w < way.length; w += 2) {
			Move.point.set(king.getPosition());
			way[w].move();
			while (way[w].scope()) {
				tmp_piece = board.getPiece(way[w].point);
				way[w].move();
			}
		}

		return false;
	}

	private boolean moveChack(Point p) {
		tmp_piece = board.getPiece(p);
		if (tmp_piece == null) {
			points.add(p);
			return true;
		}
		if (!getGroup().equals(tmp_piece.getGroup())) {
			points.add(p);
		}
		return false;
	}

	public boolean check(Board b) {
		this.board = b;
		Move.point.set(king.getPosition());
		// 차 경로
		if (checkChaPoo()) {

		}
		return false;
	}

}
