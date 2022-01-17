package com.exproject.janggi.piece;

import java.util.Iterator;

import com.exproject.janggi.Board;
import com.exproject.janggi.interfacemod.Piece;
import com.exproject.janggi.util.Move;
import com.exproject.janggi.util.Point;
import com.exproject.janggi.util.Points;

public class Sa extends PieceSet {

	private Board board;
	private Points points = new Points(8);
	private Point[] castle;
	private Piece tmp_piece;

	public Sa(Board board, int piece) {
		super(piece);
		this.board = board;
		castle = (getGroup() == Group.HAN) ? board.castleup : board.castledown;
	}

	public Iterator<Point> movable() {
		points.clear();
		if (getPosition().equals(castle[0])) {
			Move.point.set(getPosition());
			Move.RIGHT.move();
			moveChack(Move.point);
			Move.DOWN.move();
			moveChack(Move.point);
			Move.LEFTE.move();
			moveChack(Move.point);
		} else if (getPosition().equals(castle[1])) {
			Move.point.set(getPosition());
			Move.RIGHT.move();
			moveChack(Move.point);
			Move.point.set(getPosition());
			Move.DOWN.move();
			moveChack(Move.point);
			Move.point.set(getPosition());
			Move.LEFTE.move();
			moveChack(Move.point);
		} else if (getPosition().equals(castle[2])) {
			Move.point.set(getPosition());
			Move.DOWN.move();
			moveChack(Move.point);
			Move.LEFTE.move();
			moveChack(Move.point);
			Move.UP.move();
			moveChack(Move.point);
		} else if (getPosition().equals(castle[3])) {
			Move.point.set(getPosition());
			Move.UP.move();
			moveChack(Move.point);
			Move.point.set(getPosition());
			Move.RIGHT.move();
			moveChack(Move.point);
			Move.point.set(getPosition());
			Move.DOWN.move();
			moveChack(Move.point);
		} else if (getPosition().equals(castle[4])) {
			Move.point.set(getPosition());
			Move.RIGHT.move();
			moveChack(Move.point);
			Move.DOWN.move();
			moveChack(Move.point);
			Move.LEFTE.move();
			moveChack(Move.point);
			Move.LEFTE.move();
			moveChack(Move.point);
			Move.UP.move();
			moveChack(Move.point);
			Move.UP.move();
			moveChack(Move.point);
			Move.RIGHT.move();
			moveChack(Move.point);
			Move.RIGHT.move();
			moveChack(Move.point);
		} else if (getPosition().equals(castle[5])) {
			Move.point.set(getPosition());
			Move.DOWN.move();
			moveChack(Move.point);
			Move.point.set(getPosition());
			Move.LEFTE.move();
			moveChack(Move.point);
			Move.point.set(getPosition());
			Move.UP.move();
			moveChack(Move.point);
		} else if (getPosition().equals(castle[6])) {
			Move.point.set(getPosition());
			Move.UP.move();
			moveChack(Move.point);
			Move.RIGHT.move();
			moveChack(Move.point);
			Move.DOWN.move();
			moveChack(Move.point);
		} else if (getPosition().equals(castle[7])) {
			Move.point.set(getPosition());
			Move.RIGHT.move();
			moveChack(Move.point);
			Move.point.set(getPosition());
			Move.LEFTE.move();
			moveChack(Move.point);
			Move.point.set(getPosition());
			Move.UP.move();
			moveChack(Move.point);
		} else if (getPosition().equals(castle[8])) {
			Move.point.set(getPosition());
			Move.LEFTE.move();
			moveChack(Move.point);
			Move.UP.move();
			moveChack(Move.point);
			Move.RIGHT.move();
			moveChack(Move.point);
		}
		return points.getMovable();
	}

	private boolean moveChack(Point p) {
		tmp_piece = board.getPiece(p);
		if (tmp_piece == null) {
			points.add(p);
			return true;
		}
		if (!equalsTeam(tmp_piece)) {
			points.add(p);
		}
		return false;
	}
}
